package com.organization.service.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//swagger info
@Schema(
		name="Organization",
		description = "Organization Service Dto"
	)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationDto {
	@Schema(
			name="id",
			description = "OrganizationDto Id"
		)
	private Long id;
	
	@Schema(
			name="organizationName",
			description = "OrganizationDto organizationName"
		)
	private String organizationName;
	
	
	@Schema(
			name="organizationDescription",
			description = "OrganizationDto organizationName"
		)
	private String organizationDescription;
	
	
	@Schema(
			name="organizationCode",
			description = "OrganizationDto organizationCode"
		)
	private String organizationCode;
	
	
	@Schema(
			name="createdDate",
			description = "OrganizationDto createdDate"
		)
	private LocalDateTime createdDate;

}
