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
	private String cardTypeId;
	
	/*
	 * Refer to CredtiCard, DebitCard, WalletCard etc.,
	 */
	@Field(value = "CARD_ID", order = 3)
	private String cardId;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
