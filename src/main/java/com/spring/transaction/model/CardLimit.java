package com.spring.transaction.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CARD_LIMIT")
public class CardLimit {

	@Id
	@Field(value="CARD_LIMIT_ID", order = 1)							private String cardLimitId;
	
	/**
	 * 1. Refer to CREDIT_CARD_ID, DEBIT_CARD_ID, WALLET_CARD_ID, GIFT_CARD_ID, REWARD_CARD_ID, 
	 * 		VIRTUAL_CREDIT_CARD, VIRTUAL_DEBIT_CARD etc.,
	 */
	@Field(value = "CARD_ID", order = 12)
	@NotNull(message = "Card is required field.")
	private String cardId;
	
	//Message, Email, IVR, SMS, Post
	@Field(value="CARD_UPGRADE_THROUGH", order = 2) 					private String cardUpgradeThrough;
	
	@Field(value = "CARD_LIMIT_ENHANCEMENT_REQUEST_ON") 				private OffsetDateTime cardLimitEnhancementRequestOn;
	
	@Field(value="UPGRADE_LIMIT_FROM", order = 3) 						private BigDecimal upgradeLimitFrom;
	@Field(value="UPGRADE_LIMIT_TO", order = 4) 						private BigDecimal upgradeLimitTo;
	@Field(value="UPGRADE_LIMIT_ON", order = 5) 						private OffsetDateTime upgradeLimitOn;
	
	@Field(value="TEMPORARY_LIMIT_FROM", order = 6) 					private BigDecimal temporaryLimitFrom;
	@Field(value="TEMPORARY_LIMIT_TO", order = 7) 						private BigDecimal temporaryLimitTo;
	@Field(value="TEMPORARY_LIMIT_ELIGIBLE_FROM_DATE", order = 8) 		private OffsetDateTime temporaryLimitEligibleFromDate;
	@Field(value="TEMPORARY_LIMIT_ELIGIBLE_TO_DATE", order = 9) 		private OffsetDateTime temporaryLimitEligibleToDate;
	
	@Field(value = "COMMENT", order = 10)								private String comment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 11)								private String customerId;
}
