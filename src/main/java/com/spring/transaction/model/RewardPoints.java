package com.spring.transaction.model;

import java.util.Date;

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
	@NotEmpty(message = "Reward Points Catalogue is required field.")
	private String rewardPointsCatalogueId;
	
	/*
	 * 1. Trigger every month Thread cycle after statement date. Then user will know it in current statement.
	 * 2. If card is in inActive state don't run Thread cycle.
	 */
	@NotEmpty(message = "Opening Balance is required field.")
	@Field(value="REWARDS_OPENING_BALANCE", order = 4)
	private long rewardsOpeningBalance;
	
	@NotEmpty(message = "Reward Points Earned is required field.")
	@Field(value="REWARD_POINTS_EARNED", order = 5)
	private long rewardPointsEarned;
	
	/*
	 * 1. This Field is main for anyone of the following transactions Redeemed/Expired/Adjusted
	 * 2. All individual transactions will be shown in REWARD_POINTS_REDEEM
	 */
	@Field(value="REWARDS_ADJUSTED", order = 6)
	private long rewardsAdjusted;
	
	@Field(value="BONUS_POINTS", order = 7) private long bonusPoints;
	
	@Field(value="REWARDS_CLOSING_BALANCE", order = 8) private long rewardsClosingBalance;
	
	@Field(value="REWARD_POINTS_ADDED_ON", order = 9)
	private Date rewardPointsAddedOn;
	
	@Field(value="MERCHANT_DETAILS_ID", order = 10)
	@NotEmpty(message = "Merchant Name is required field.")
	private String merchantDetailsId;
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 11)
	@NotEmpty(message = "Reward Points Earned is required field.")
	private String rewardPointsEarnedId;
	
	@NotEmpty(message = "Each Point Value is required field.")
	@Field(value="EACH_POINT_VALUE", order = 12) private long eachPointValue;
	
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 13)
	@NotEmpty(message = "Reward Points Redeemed To is required field.")
	private String rewardPointsRedeemId;
	
	@Field(value="CUSTOMER_ID", order = 14)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
