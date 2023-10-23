package com.department.service.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//BAD_REQUEST
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetailsModel> resourceNotFoundException(Exception exception,WebRequest webRequest){
		
		ErrorDetailsModel errorDetails = new ErrorDetailsModel(LocalDateTime.now(), exception.getMessage(),
				webRequest.getDescription(false), "NOT_FOUND_404");
		
		return new ResponseEntity<ErrorDetailsModel>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DepartmentCodeAlreadyExistException.class)
	public ResponseEntity<ErrorDetailsModel> handledDepartmentCodeAlreadyExistException(DepartmentCodeAlreadyExistException exception,
			WebRequest webRequest) {

		ErrorDetailsModel errorDetails = new ErrorDetailsModel(LocalDateTime.now(), exception.getMessage(),
				webRequest.getDescription(false), "BAD_REQUEST");
		return new ResponseEntity<ErrorDetailsModel>(errorDetails, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetailsModel> getException(Exception exception,WebRequest webRequest){
		
		ErrorDetailsModel errorDetails=new ErrorDetailsModel(LocalDateTime.now(),exception.getMessage(),
				webRequest.getDescription(false),"INTERNAL_SERVER_ERROR");
		log.info("Exception Details :::"+errorDetails.getTimestamp()+":::"+errorDetails.getClass()+":::"+errorDetails.getPath()+":::"+errorDetails.getMessage()+":::"+errorDetails.getErrorCode());
		return new ResponseEntity<ErrorDetailsModel>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			
		
		Map<String,String> errors=new HashMap<>();
		
		List<ObjectError> errorList=ex.getBindingResult().getAllErrors();
		
		errorList.forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			
			String message=error.getDefaultMessage();
			
			errors.put(fieldName, message);
			
		});
		
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}

}
