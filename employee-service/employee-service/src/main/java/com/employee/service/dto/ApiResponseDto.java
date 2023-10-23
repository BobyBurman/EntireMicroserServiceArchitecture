package com.employee.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//swagger info
@Schema(
		description = "Api Response Dto"
	)
public class ApiResponseDto {
	
	@Schema(
			description = "ApiResponseDto EmployeeDto"
		)
	private EmployeeDto employeeDto;
	
	@Schema(
			description = "ApiResponseDto DepartmentDto"
		)
	private DepartmentDto departmentDto;
	
	@Schema(
			description = "ApiResponseDto organizationDto"
		)
	private OrganizationDto organizationDto;

}
