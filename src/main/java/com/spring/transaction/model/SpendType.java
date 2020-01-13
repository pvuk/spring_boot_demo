package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "SPEND_TYPE_CODE")
public class SpendType {
	
	@Id
	@Field(value = "SPEND_TYPE_ID")						private String spendTypeId;

	@Indexed(unique=true)
	@Field(value="CODE")								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Spend Type is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
