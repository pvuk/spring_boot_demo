package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "SPEND_STATUS_CODE")
public class SpendStatus {
	
	@Id
	@Field(value = "SPEND_STATUS_ID")					private String spendStatusId;
	
	@Field(value="CODE")
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Spend Status is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
