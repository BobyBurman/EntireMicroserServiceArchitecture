package com.organization.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.service.dto.OrganizationDto;
import com.organization.service.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

//swagger info
@Tag(
		name = "Organization Service - Organization Controller", 
		description = "Organization Controller Exposes REST APIs for Organization-Service"
	)

@RestController()
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	// swagger info
	@Operation(
			summary = "Save Organization REST API", 
			description = "Save Organization REST API is used to save organization object in a Database"
			)
	@ApiResponse(
			responseCode = "201", 
			description = "HTTP Status 201 CREATED"
			)

	// Build save organization api
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

		OrganizationDto savedOrganizationDto = this.organizationService.savaOrganizationDto(organizationDto);

		return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.CREATED);

	}

	// swagger info
	@Operation(
			summary = "Get Organization REST API", 
			description = "Get Organization REST API is used to get organization object in a Database"
			)
	@ApiResponse(
			responseCode = "200", 
			description = "HTTP Status 200 SUCCESS"
	)

	// Build get Organization api
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {

		OrganizationDto organizationDto = this.organizationService.getOrganizationDto(organizationCode);

		return new ResponseEntity<OrganizationDto>(organizationDto, HttpStatus.OK);
	}

}
