package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "TRANSACTION_STATUS_CODE")
public class TransactionStatus {
	
	@Id
	@Field(value = "TRANSACTION_STATUS_ID")					private String transactionStatusId;
	
	@Field(value="CODE")
	@Indexed(unique=true)									private String code;
	
	@Field(value="POSITION") 								private Long position;
	
	@NotNull(message="Transfer Type is required field.")
	@Field(value="DESCRIPTION") 							private String description;
}
