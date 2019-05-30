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

	@Field(value = "CREDIT_CARD_ID", order = 1)
	@Id
	private String creditCardId;

	@Field(value="CODE", order = 2) private String code;
	
	@Field(value="POSITION", order = 3) private Long position;
	
	@Field(value="DESCRIPTION", order = 4)
	@NotNull(message="Card Name is required field.")
	private String description;
}
