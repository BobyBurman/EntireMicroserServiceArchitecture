package com.department.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//swagger info
@Tag(
		name="Department Service - Message Controller",
		description ="Message Controller Exposes REST APIs for application.properties in Git"
)

@RestController
@RefreshScope
public class MessageController {
	//To check config update from github commom config
	@Value("${spring.cloud.message}")
	private String message;
	
	
	@Operation(
			summary = "Get Message REST API",
			description = "Get Message REST API is used to check config updation from github commom config"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	
	@GetMapping("message")
	public String getMessage() {
		return this.message;
	}

}
