package com.example.product.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration for API Documentation
 * 
 * http://localhost:8080/swagger-ui.html
 * 
 * @author Vineeth Soman
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.product.controller")).build().apiInfo(apiInfo());

	}

	/**
	 * Configuration API documentation
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiinfo = new ApiInfo("Application REST API for Product", "Application manager REST API documentation.",
				"API 1.0", "Terms of service based into company terms of use",
				new Contact("Vineeth Soman", null, "vineethsoman.2011@gmail.com"),
				"Licence of API for development use only", null, Collections.emptyList());
		return apiinfo;
	}
}
