package com.spring.transaction.test.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "TEST_JSON_MODEL")
public class TestJsonModel {
	
	@Id
	@Field(value="ID", order = 1)											private String id;
	
	@Field(value="CODE", order = 2) 										private String code;
	@Field(value="POSITION", order = 3) 									private Long position;
	
	@NotNull(message="Wallet Name is required field.")
	@Field(value="DESCRIPTION", order = 4)									private String description;
	
	@Field(value = "DETAILS", order = 5)									private String details;
	
}
