package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "NEW_OPTION_REQUEST")
public class NewOptionRequest {
	
	@Id
	@Field(value = "NEW_OPTION_REQUEST_ID")													private String newOptionRequestId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "New Option Request Code is required field.")
	@Field(value = "CODE", order = 2)														private String code;

	@Field(value = "POSITION", order = 3)													private int position;

	@NotNull(message = "New Option Request is required field.")
	@Field(value = "DESCRIPTION", order = 4)												private String description;

}
