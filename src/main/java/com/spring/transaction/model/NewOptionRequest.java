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
	
	@Field(value = "NEW_OPTION_REQUEST_ID")
	@Id																	private String newOptionRequestId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "New Option Request Code is required field.")	private String code;

	@Field(value = "POSITION", order = 3)								private int position;

	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "New Option Request is required field.")			private String description;

}
