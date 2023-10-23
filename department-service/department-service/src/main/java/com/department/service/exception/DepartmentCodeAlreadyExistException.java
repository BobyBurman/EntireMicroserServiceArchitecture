package com.department.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class DepartmentCodeAlreadyExistException extends RuntimeException{
	private String message;
	
	public DepartmentCodeAlreadyExistException(String message) {
		super(message);
		this.message=message;
	}

}
