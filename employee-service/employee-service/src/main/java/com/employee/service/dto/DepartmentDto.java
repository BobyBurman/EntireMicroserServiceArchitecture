package com.employee.service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentDto {

	private Long Id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;

}
