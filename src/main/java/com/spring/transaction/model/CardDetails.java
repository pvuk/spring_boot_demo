package com.spring.transaction.model;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.Data;

@Data
@Document(collection="CARD_DETAILS")
public class CardDetails {

	@Field(value = "CARD_DETAILS_ID", order = 1)
	@Id
	private String cardDetailsId;
	
	@Field(value = "CARD_TYPE_ID", order = 2)
	@NotNull(message = "Card Type is required field.")
	private String cardTypeId;
	
	/**
	 * 1. Refer to CREDIT_CARD_ID, DEBIT_CARD_ID, WALLET_CARD_ID, GIFT_CARD_ID, REWARD_CARD_ID etc.,
	 */
	@Field(value = "CARD_ID", order = 3)
	@NotNull(message = "Card is required field.")
	private String cardId;
	
	private String feesAndChargesId;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
