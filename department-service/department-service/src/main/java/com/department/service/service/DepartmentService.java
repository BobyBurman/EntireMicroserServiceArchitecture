package com.department.service.service;

import com.department.service.dto.DepartmentDto;

public interface DepartmentService {
	
	public DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	public DepartmentDto getDepartmentByCode(String departmentCode);

}
