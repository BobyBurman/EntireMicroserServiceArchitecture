package com.organization.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.organization.service.dto.OrganizationDto;
import com.organization.service.entity.Organization;
import com.organization.service.repository.OrganizationRepository;
import com.organization.service.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl<OrganizationDTo> implements OrganizationService{
	
	
	private ModelMapper mapper;
	
	private OrganizationRepository organizationRepository;

	@Override
	public OrganizationDto savaOrganizationDto(OrganizationDto organizationDto) {
		
		//dto to jpa entity
		Organization organization=mapper.map(organizationDto,Organization.class);
		
		Organization savedOrganization=organizationRepository.save(organization);
		
		//jpa entity to dto
		OrganizationDto getOrganizationDto=mapper.map(savedOrganization,OrganizationDto.class);
		
		return getOrganizationDto;
	}

	@Override
	public OrganizationDto getOrganizationDto(String organizationCode) {
		
		Organization organization=organizationRepository.findByOrganizationCode(organizationCode) ;
		
		//jpa to dto
		
		OrganizationDto organizationDto=mapper.map(organization,OrganizationDto.class);
		
		return organizationDto;
		
	}
	
	

}
