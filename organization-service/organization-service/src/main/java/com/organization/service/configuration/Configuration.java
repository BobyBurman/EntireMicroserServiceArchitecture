package com.organization.service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	//modelmapper config
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
