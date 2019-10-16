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
@Document(collection = "REWARD_POINTS_DETAILS")
public class RewardPointsDetails {
	
	@Field(value="REWARD_POINTS_DETAILS_ID", order = 1)
	@Id
	private String rewardPointsDetailsId;
	
	/*
	 * 1. Only one record allows per card, per statement in REWARD_POINTS
	 */
	@Field(value="REWARD_CARD_ID", order = 2)
	@NotNull(message = "Reward Card is required field.")
	private String rewardCardId;
	
	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 3)
//	@NotNull(message = "Reward Points Catalogue is required field.")
	private String rewardPointsCatalogueId;
	
	@Field(value="MERCHANT_DETAILS_ID", order = 10)
//	@NotNull(message = "Merchant Name is required field.")
	private String merchantDetailsId;
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 11)
	@NotNull(message = "Reward Points Earned is required field.")
	private String rewardPointsEarnedId;
	
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 13)
//	@NotNull(message = "Reward Points Redeemed To is required field.")
	private String rewardPointsRedeemId;
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID", order = 14)
	@NotNull(message = "Credit Card Statement is required field.")
	private String creditCardStatementId;
	
	@Field(value="CUSTOMER_ID", order = 15)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
