package com.employee.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeGlobalExceptionHandlerClass extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<EmployeeErrorModel> getGenericException(Exception exception, WebRequest webRequest){
		
		EmployeeErrorModel employeeErrorModel=new EmployeeErrorModel(LocalDateTime.now(),exception.getMessage(),
				webRequest.getDescription(false),"INTERNAL_SERVER_ERROR");
		
		return new ResponseEntity<EmployeeErrorModel>(employeeErrorModel,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
