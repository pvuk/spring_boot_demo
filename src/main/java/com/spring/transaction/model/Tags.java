package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="TAGS")
public class Tags {
	
	@Id
	private String tagsId;
	
	private String name;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
