package com.spring.transaction.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private String basePackage = "com.spring.transaction.controller";

	@Bean
	public Docket bankAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("BankAPI")
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(regex("/bank/service.*"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Trans", "1.0", "Terms of service", new Contact("Uday Kiran P", "", "udaykiran.pulipati@gmail.com"), 
				"Apache License Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}
	
	@Bean
	public Docket bankBranchAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("BankBranchAPI")
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(regex("/bankBranch/service.*"))
				.build()
				.apiInfo(metaData());
				
	}
}
