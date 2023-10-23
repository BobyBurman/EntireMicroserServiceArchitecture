package com.department.service.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsModel {

	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;
	
	

}
