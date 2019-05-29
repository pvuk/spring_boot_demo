package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "DEBIT_CARD_CODE")
public class DebitCard {

	@Field(value = "DEBIT_CARD_ID")
	@Id
	private String debitCardId;
	
	@Field(value="CODE") private String code;
	
	@Field(value="POSITION") private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION") private String description;

}
