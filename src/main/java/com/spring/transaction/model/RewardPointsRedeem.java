package com.spring.transaction.model;

import java.util.Date;

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
@Document(collection = "REWARD_POINTS_REDEEM")
public class RewardPointsRedeem {

	@Field(value="REWARD_POINTS_REDEEM_ID")
	@Id
	private String rewardPointsRedeemId;

	@Field(value="REWARD_CARD_ID") private String rewardCardId;
	
	@Field(value="REWARDS_REDEEMED_THIS_MONTH") private long rewardsRedeemedThisMonth;

	@Field(value="REWARDS_REDEEMED_TO") private long rewardsRedeemedTo;

	@Field(value="REWARDS_ADJUSTED") private long rewardsAdjusted;

	@Field(value="REWARDS_EXPIRE_THIS_MONTH") private long rewardsExpireThisMonth;
	
	//SBI Bank Rewards Feature
	@Field(value="REWARDS_EXPIRE_NEXT_MONTH") private long rewardsExpireNextMonth;
	@Field(value="REWARDS_EXPIRE_NEXT_THREE_MONTH") private long rewardsExpireNextThreeMonth;

	@Field(value="POINTS_EXPIRE_ON") private Date pointsExpireOn;

	@Field(value="TOTAL_POINTS_EXPIRE") private long totalPointsExpire;

	@Field(value="POINTS_EXPIRE_DETAILS") private String pointsExpireDetails;
	
	@Field(value="COMMENT") private String comment;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
