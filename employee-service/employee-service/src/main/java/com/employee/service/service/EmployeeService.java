package com.employee.service.service;

import com.employee.service.dto.ApiResponseDto;
import com.employee.service.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto saveEmployee(EmployeeDto dto);
	
	public ApiResponseDto getEmployeeById(Long id);

}
