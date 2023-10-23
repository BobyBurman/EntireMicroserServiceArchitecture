package com.department.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.department.service.dto.DepartmentDto;
import com.department.service.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

//swagger info
@Tag(
		name="Department Service - Department Controller",
		description ="Department Controller Exposes REST APIs for Department-Service"
)

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	//swagger info
	@Operation(
			summary = "Save Department REST API",
			description = "Save Department REST API is used to save department object in a Database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	//Build save department REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment=departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<DepartmentDto>(savedDepartment, HttpStatus.CREATED);
	}
	
	//swagger info
	@Operation(
			summary = "Get Department REST API",
			description = "Get Department REST API is used to get department object in a Database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	
	//Build GET department REST API
	@GetMapping
	public ResponseEntity<DepartmentDto> getDepartment(@RequestParam("departmentCode") String departmentCode){
		DepartmentDto getDepartment=departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<DepartmentDto>(getDepartment,HttpStatus.OK);
	}
	

}
