package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="TAGS")
public class Tags {
	
	@Id
	@Field(value = "TAGS_ID")									private String tagsId;
	
	@NotNull(message = "Code is required field.")
	@Field(value = "NAME")										private String name;
	
	@NotNull(message="Customer is required field.")
	@Field(value = "CUSTOMER_ID")								private String customerId;
	
}
