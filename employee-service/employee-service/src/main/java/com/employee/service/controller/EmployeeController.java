package com.employee.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.dto.ApiResponseDto;
import com.employee.service.dto.EmployeeDto;
import com.employee.service.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

//swagger info
@Tag(
		name = "Employee Service - Organization Controller", 
		description = "EmployeeController Exposes REST APIs for Employee-Service"
	)

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	// swagger info
	@Operation(
			summary = "Save Employee REST API", 
			description = "Save Employee REST API is used to save employee object in a Database"
			)
	@ApiResponse(
			responseCode = "201", 
			description = "HTTP Status 201 CREATED"
			)
	//Build save Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee,HttpStatus.CREATED);
		
	}
	
		
		
	// swagger info
	@Operation(
			summary = "Get Employee REST API", 
			description = "Get Employee REST API is used to get employee object in a Database"
			)
	@ApiResponse(
			responseCode = "200", 
			description = "HTTP Status 200 SUCCESS"
	)	
	//Build get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long id){
		ApiResponseDto apiResponseDto=employeeService.getEmployeeById(id);
		return new ResponseEntity<ApiResponseDto>(apiResponseDto,HttpStatus.OK);
		
	}

}
