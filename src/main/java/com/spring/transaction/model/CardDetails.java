package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CARD_DETAILS")
public class CardDetails {

	@Field(value = "CARD_DETAILS_ID")
	@Id
	private String cardDetailsId;
	
	private String cardTypeId;
	
	/*
	 * Refer to CredtiCard, DebitCard, WalletCard etc.,
	 */
	private String cardId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
