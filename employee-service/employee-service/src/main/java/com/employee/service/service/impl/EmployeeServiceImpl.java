package com.employee.service.service.impl;



import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.service.dto.ApiResponseDto;
import com.employee.service.dto.DepartmentDto;
import com.employee.service.dto.EmployeeDto;
import com.employee.service.dto.OrganizationDto;
import com.employee.service.entity.Employee;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.service.ApiFeignClients;
import com.employee.service.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	private ModelMapper modelMapper;
	
	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	private ApiFeignClients apiFeignClients;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		//Convert Employee DTO TO JPA entity using modelmapper
		Employee employee=modelMapper.map(employeeDto,Employee.class);
		
		//saving employee data to DB
		Employee savedEmployee=employeeRepository.save(employee);
		
		//convert employee JPS entity to DTO using modelmapper
		EmployeeDto savedEmployeeDto=modelMapper.map(savedEmployee, EmployeeDto.class);
		
		return savedEmployeeDto;
	}
    //@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		
		//find employee basis on employee_id from DB
		Employee employee=employeeRepository.findById(id).get();
	
		//convert employee JPS entity to DTO using modelmapper
		EmployeeDto getEmployeeDto=modelMapper.map(employee, EmployeeDto.class);
		
		
		/*Rest call to department service*/
		log.info("Before restcall Department-Service");
		//ResponseEntity<DepartmentDto> departmentDto=restTemplate.getForEntity("http://localhost:9001/api/departments?departmentCode="+getEmployeeDto.getDepartmentCode(),DepartmentDto.class);
		
		//DepartmentDto departmentDto=webClient.get().uri("http://localhost:9001/api/departments?departmentCode="+getEmployeeDto.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
		ResponseEntity<DepartmentDto> departmentDtoFieng=apiFeignClients.getDepartment(getEmployeeDto.getDepartmentCode());
		DepartmentDto departmentDto=departmentDtoFieng.getBody();
		log.info("After restcall Department-Service");
		
		
		/*RestCall to Organization service*/
		log.info("Before restcall Organization-Service");
		OrganizationDto organizationDto=webClient.get().uri("http://localhost:9003/api/organization/"+getEmployeeDto.getOrganizationCode())
		.retrieve().bodyToMono(OrganizationDto.class).block();
		log.info("After restcall Organization-Service");
		
		//setting ApiResponseDto
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(getEmployeeDto);
		apiResponseDto.setOrganizationDto(organizationDto);
		
		return apiResponseDto;
	}
    
	public ApiResponseDto getDefaultDepartment(Long id,Exception ex) {

		// find employee basis on employee_id from DB
		Employee employee = employeeRepository.findById(id).get();

		// convert employee JPS entity to DTO using modelmapper
		EmployeeDto getEmployeeDto = modelMapper.map(employee, EmployeeDto.class);

		// Rest call to department service
		log.info("Before Department-Service restcall failure---fallback back method");
		
		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setDepartmentName("R&D department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research & Development department");
		
		log.info("After Department-Service restcall failure---fallback back method");
		
		
		/*RestCall to Organization service*/
		log.info("Before Organization-Service restcall failure---fallback back method");
		OrganizationDto organizationDto=new OrganizationDto();
		organizationDto.setOrganizationName("Default Fallback");
		organizationDto.setOrganizationDescription("Default Fallback");
		organizationDto.setOrganizationCode("Default Fallback");
		log.info("After Organization-Service restcall failure---fallback back method");

		// setting ApiResponseDto
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(getEmployeeDto);
		apiResponseDto.setOrganizationDto(organizationDto);

		return apiResponseDto;
	}

}
