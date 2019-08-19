package com.spring.transaction.model;

import java.sql.Timestamp;
import java.util.Date;

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

	@Field(value="CARD_LIMIT_ID", order = 1)
	@Id
	private String cardLimitId;
	
	//Message, Email, ITR, SMS, Post
	@Field(value="CARD_UPGRADE_THROUGH", order = 2) private String cardUpgradeThrough;
	
	@Field(value = "CARD_LIMIT_ENHANCEMENT_REQUEST_ON") private Date cardLimitEnhancementRequestOn;
	
	@Field(value="UPGRADE_LIMIT_FROM", order = 3) private Long upgradeLimitFrom;
	@Field(value="UPGRADE_LIMIT_TO", order = 4) private Long upgradeLimitTo;
	@Field(value="UPGRADE_LIMIT_ON", order = 5) private Timestamp upgradeLimitOn;

	@Field(value="TEMPORARY_LIMIT_FROM", order = 6) 				private Long temporaryLimit;
	@Field(value="TEMPORARY_LIMIT_TO", order = 7) 					private Date temporaryLimitFrom;
	@Field(value="TEMPORARY_LIMIT_ELIGIBLE_FROM_DATE", order = 8) 	private Date temporaryLimitEligibleFromDate;
	@Field(value="TEMPORARY_LIMIT_ELIGIBLE_TO_DATE", order = 9) 	private Date temporaryLimitEligibleToDate;
	
	@Field(value = "CARD_DETAILS_ID", order = 10)
	private String cardDetailsId;
	
	@Field(value="CUSTOMER_ID", order = 11)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
