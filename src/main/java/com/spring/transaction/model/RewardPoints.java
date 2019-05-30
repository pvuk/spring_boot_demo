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
	
	@Field(value="REWARD_CARD_ID", order = 2)
	@NotEmpty(message = "Reward Card is required field.")
	private String rewardCardId;
	
	@Field(value="REWARD_POINTS_CATALOGUE_ID", order = 3)
	@NotEmpty(message = "Reward Points Catalogue is required field.")
	private String rewardPointsCatalogueId;
	
	@Field(value="REWARDS_OPENING_BALANCE", order = 4)
	@NotEmpty(message = "Opening Balance is required field.")
	private long rewardsOpeningBalance;
	
	@Field(value="MERCHANT_DETAILS_ID", order = 5)
	@NotEmpty(message = "Merchant Name is required field.")
	private String merchantDetailsId;
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 6)
	@NotEmpty(message = "Reward Points Earned is required field.")
	private String rewardPointsEarnedId;
	
	@Field(value="BONUS_POINTS", order = 7) private long bonusPoints;
	
	@Field(value="POINTS_EQUAL_TO_MONEY_VALUE", order = 8) private long pointsEqualToMoneyValue;
	
	@Field(value="REWARDS_CLOSING_BALANCE", order = 9) private long rewardsClosingBalance;
	
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 10)
	@NotEmpty(message = "Reward Points Redeemed To is required field.")
	private String rewardPointsRedeemId;
	
	@Field(value="CUSTOMER_ID", order = 11)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
