package com.spring.transaction.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.transaction.model.Bank;
import com.spring.transaction.model.BankBranch;

@Configuration
@Component
public class TransRestConfigurer implements RepositoryRestConfigurer {
	@Override
	public void configureJacksonObjectMapper(ObjectMapper objectMapper) {

//		configureJacksonObjectMapper(objectMapper);
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Bank.class, BankBranch.class);
	}
}
