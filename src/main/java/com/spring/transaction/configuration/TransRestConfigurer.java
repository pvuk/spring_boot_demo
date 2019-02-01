package com.spring.transaction.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.transaction.model.Bank;

@Configuration
@Component
public class TransRestConfigurer extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureJacksonObjectMapper(ObjectMapper objectMapper) {

		super.configureJacksonObjectMapper(objectMapper);
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		super.configureRepositoryRestConfiguration(config);
		config.exposeIdsFor(Bank.class);
	}
}
