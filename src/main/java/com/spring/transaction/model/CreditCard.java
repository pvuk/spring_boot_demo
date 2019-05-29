package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "CREDIT_CARD_CODE")
public class CreditCard {

	@Field(value = "CREDIT_CARD_ID")
	@Id
	private String creditCardId;

	@Field(value="CODE") private String code;
	
	@Field(value="POSITION") private Long position;
	
	@NotNull(message="Card Name is required field.")
	@Field(value="DESCRIPTION") private String description;
}
