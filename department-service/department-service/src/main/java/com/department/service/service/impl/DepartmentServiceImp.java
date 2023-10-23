package com.department.service.service.impl;

import org.springframework.stereotype.Service;

import com.department.service.converter.Converter;
import com.department.service.dto.DepartmentDto;
import com.department.service.entity.Department;
import com.department.service.exception.DepartmentCodeAlreadyExistException;
import com.department.service.exception.ResourceNotFoundException;
import com.department.service.repository.DepartmentRepository;
import com.department.service.service.DepartmentService;



import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService{

	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		//convert department DTO to department JPA entity
		Department department=Converter.departmentDtoToJpa(departmentDto);
		
		//checking already existing departmentCode
		Department savedDepartment;
		Department isDepartmentCodeExist = departmentRepository.findByDepartmentCode(department.getDepartmentCode());
		if (isDepartmentCodeExist != null && isDepartmentCodeExist.getDepartmentCode() != null) {
			throw new DepartmentCodeAlreadyExistException(
					isDepartmentCodeExist.getDepartmentCode() + " : This DepartmentCode already exist & department code should be unique!!!");
		} else {

			// saving it to DB
			savedDepartment = departmentRepository.save(department);
		}
		//converting department JPA to department DTO
		DepartmentDto savedDepartmentDto=Converter.departmentJpaToDto(savedDepartment);
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		//getting it from DB
		Department getDepartment=departmentRepository.findByDepartmentCode(departmentCode);
		
		if(getDepartment==null) {
			throw new ResourceNotFoundException("departmentName","departmentCode",
					departmentCode);
		}
		
		//converting department JPA entity to department DTO
		DepartmentDto getDepartmentDto=Converter.departmentJpaToDto(getDepartment);
		
		return getDepartmentDto;
	}

}
