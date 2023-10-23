package com.organization.service.service;

import com.organization.service.dto.OrganizationDto;

public interface OrganizationService{
	
	OrganizationDto savaOrganizationDto(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationDto(String organizationCode);

}
