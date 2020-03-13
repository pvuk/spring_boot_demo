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

	@Id
	@Field(value = "CARD_DETAILS_ID", order = 1)
	private String cardDetailsId;
	
	@NotNull(message = "Card Type is required field.")
	@Field(value = "CARD_TYPE_ID", order = 2)
	private String cardTypeId;
	
	/**
	 * 1. Refer to CREDIT_CARD_ID, DEBIT_CARD_ID, WALLET_CARD_ID, GIFT_CARD_ID, REWARD_CARD_ID, 
	 * 		VIRTUAL_CREDIT_CARD, VIRTUAL_DEBIT_CARD etc.,
	 * 2. Maintain Format XX_XXXX_XXXX
	 */
	@NotNull(message = "Card is required field.")
	@Field(value = "CARD_ID", order = 3)
	private String cardId;
	
	@Field(value = "FEES_AND_CHARGES_ID")
	private String feesAndChargesId;
	
	/**
	 * 1.* When CREDIT_CARD_CODE is upgraded update CREDIT_CARD_ID with UPGRADE_FROM_CARD_ID and new card with UPGRADE_TO_CARD_ID.
	 * 2. ACTIVE set false, UPGRADED true.
	 */
	@Field(value="UPGRADE_FROM_CARD_ID", order = 8)										private String upgradeFromCardId;
	@Field(value="UPGRADE_TO_CARD_ID", order = 8)										private String upgradeToCardId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 4)
	private String customerId;
	
	@Embedded
	private AuditData auditData;
}
