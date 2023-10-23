package com.employee.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

//swagger info
@OpenAPIDefinition(
		
		info=@Info(
				title="EMPLOYEE-SERVICE REST APIs",
				description = "Employee Service REST APIs Documentation",
				version="V1.1.6.11 - springdoc-openapi-ui",
				contact=@Contact(
						name="Boby Burman",
						email="iamboby000@gmail.com",
						url="https://github.com/BobyBurman/"
						),
				license = @License(
						name="Apache License, Version 2.0",
						url="https://www.apache.org/licenses/LICENSE-2.0"
						)
				),
		externalDocs = @ExternalDocumentation(
				description="EMPLOYEE-SERVICE DOCS",
				url = "https://github.com/spring-projects/spring-boot/issues"
				)
		
)

public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
