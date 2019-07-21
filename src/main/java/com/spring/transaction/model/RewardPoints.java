package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;
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
@Document(collection = "REWARD_POINTS")
public class RewardPoints {
	
	@Field(value="REWARD_POINTS_ID", order = 1)
	@Id
	private String rewardPointsId;
	
	/*
	 * 1. Only one record allows per card, per statement in REWARD_POINTS
	 */
	@Field(value="REWARD_CARD_ID", order = 2)
	@NotEmpty(message = "Reward Card is required field.")
	private String rewardCardId;
	
	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 3)
//	@NotEmpty(message = "Reward Points Catalogue is required field.")
	private String rewardPointsCatalogueId;
	
	@Field(value="MERCHANT_DETAILS_ID", order = 10)
//	@NotEmpty(message = "Merchant Name is required field.")
	private String merchantDetailsId;
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 11)
	@NotEmpty(message = "Reward Points Earned is required field.")
	private String rewardPointsEarnedId;
	
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 13)
//	@NotEmpty(message = "Reward Points Redeemed To is required field.")
	private String rewardPointsRedeemId;
	
	@Field(value = "STATEMENT_CREDIT_CARD_ID", order = 14)
	@NotEmpty(message = "Statement Of Credit Card is required field.")
	private String statementCreditCardId;
	
	@Field(value="CUSTOMER_ID", order = 15)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
