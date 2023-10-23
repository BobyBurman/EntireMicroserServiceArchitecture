package com.department.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;

	public ResourceNotFoundException(String departmentName, String departmentCode, String departmentDescription) {
		super(String.format("%s is not found with %s : '%s'",departmentName,departmentCode,departmentDescription));
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentCode = departmentCode;
	}

}
