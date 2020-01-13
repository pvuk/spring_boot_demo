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
	
	@Id
	@Field(value="REWARD_POINTS_DETAILS_ID", order = 1)
	private String rewardPointsDetailsId;
	
	/**
	 * 1. Only one record allows per card, per statement in REWARD_POINTS_DETAILS
	 */
	@NotNull(message = "Reward Card is required field.")
	@Field(value="REWARD_CARD_ID", order = 2)
	private String rewardCardId;
	
//	@NotNull(message = "Reward Points Catalogue is required field.")
	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 3)
	private String rewardPointsCatalogueId;
	
//	@NotNull(message = "Merchant Name is required field.")
	@Field(value="MERCHANT_DETAILS_ID", order = 4)
	private String merchantDetailsId;
	
	@NotNull(message = "Reward Points Earned is required field.")
	@Field(value="REWARD_POINTS_EARNED_ID", order = 5)
	private String rewardPointsEarnedId;
	
//	@NotNull(message = "Reward Points Redeemed To is required field.")
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 6)
	private String rewardPointsRedeemId;
	
	@NotNull(message = "Credit Card Statement is required field.")
	@Field(value = "CREDIT_CARD_STATEMENT_ID", order = 7)
	private String creditCardStatementId;
	
	@Field(value = "REWARD_POINTS_BONUS_ID", order = 8)
	private String rewardPointsBonusId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 9)
	private String customerId;
	
}
