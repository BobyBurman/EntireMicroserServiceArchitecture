package com.department.service.converter;

import com.department.service.dto.DepartmentDto;
import com.department.service.entity.Department;

public class Converter {
	
	//convert department dto to department jpa entity
	public static Department departmentDtoToJpa(DepartmentDto departmentDto) {
		Department department=new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode()
				);
		return department;
	}
	
	//convert department jpa entity to department dto
	public static DepartmentDto departmentJpaToDto(Department department) {
		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setDepartmentName(department.getDepartmentName());
		departmentDto.setDepartmentDescription(department.getDepartmentDescription());
		departmentDto.setDepartmentCode(department.getDepartmentCode());
		return departmentDto;
	}

}
