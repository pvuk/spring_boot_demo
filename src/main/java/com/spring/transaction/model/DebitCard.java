package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "DEBIT_CARD_CODE")
public class DebitCard {

	@Id
	@Field(value = "DEBIT_CARD_ID", order = 1)								private String debitCardId;
	
	@Field(value="CODE", order = 2) 										private String code;
	
	@Field(value="POSITION", order = 3) 									private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION", order = 4) 									private String description;

}
