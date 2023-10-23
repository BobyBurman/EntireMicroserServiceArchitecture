package com.employee.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.employee.service.dto.DepartmentDto;

//@FeignClient(url = "http://localhost:9001",value ="DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")
public interface ApiFeignClients {
	
	//Build GET department REST API
	@GetMapping("api/departments")
	public ResponseEntity<DepartmentDto> getDepartment(@RequestParam("departmentCode") String departmentCode);

}
