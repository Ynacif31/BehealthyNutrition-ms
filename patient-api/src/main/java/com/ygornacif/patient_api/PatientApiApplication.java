package com.ygornacif.patient_api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Patient microservice REST API Documentation",
				description = "BeHealthyNutrition Patient microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ygor Nacif",
						email = "ygor.nacif31@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "BeHealthyNutrition Patient microservice REST API Documentation"
		)
)
public class PatientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApiApplication.class, args);
	}

}
