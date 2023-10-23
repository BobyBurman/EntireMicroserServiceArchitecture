package com.organization.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.service.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	Organization findByOrganizationCode(String organizationCode);

}
