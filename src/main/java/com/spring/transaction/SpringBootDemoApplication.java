package com.spring.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author venkataudaykiranp
 * 
 * <p>
 * 	we can start Spring boot application without using {@link org.springframework.boot.autoconfigure.SpringBootApplication @SpringBootApplication}.<br>
 * 	Ex: We can also start Spring boot application by Configure with below annotations
 * 		{@link org.springframework.context.annotation.Configuration @Configuration }, 
 * 		{@link org.springframework.boot.autoconfigure.EnableAutoConfiguration @EnableAutoConfiguration}
 * </p>
 * <p>
 * 	The {@link org.springframework.boot.autoconfigure.SpringBootApplication @SpringBootApplication}
 *  annotation enables auto-configuration and component scanning.
 * </p>
 *
 */
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
}
