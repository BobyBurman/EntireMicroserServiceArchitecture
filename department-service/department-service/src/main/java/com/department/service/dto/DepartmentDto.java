package com.department.service.dto;

import javax.persistence.Column;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//swagger info
@Schema(
		name="Department",
		description = "Department Service Dto"
	)


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentDto {
	
	@Schema(
			name="id",
			description = "DepartmentDto Id"
			)
	private Long id;
	
	
	
	
	@Schema(
			name="departmentName",
			description = "DepartmentDto DepartmentName"
			)
	private String departmentName;
	
	
	
	@Schema(
			name="departmentDescription",
			description = "DepartmentDto DepartmentDescription"
			)
	private String departmentDescription;
	
	
	
	@Schema(
			name="departmentCode",
			description = "DepartmentDto DepartmentCode"
			)
	private String departmentCode;

}
