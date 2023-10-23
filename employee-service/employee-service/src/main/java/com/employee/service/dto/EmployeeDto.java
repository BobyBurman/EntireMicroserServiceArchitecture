package com.employee.service.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {
	
	private Long id;

	private String firstName;

	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	

	private String departmentCode;
	
	private String organizationCode;
}
