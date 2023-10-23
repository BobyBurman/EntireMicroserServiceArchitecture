package com.organization.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> getGenericException(Exception exception, WebRequest webRequest){
		
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),
				webRequest.getDescription(false),"INTERNAL_SERVER_ERROR");
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
