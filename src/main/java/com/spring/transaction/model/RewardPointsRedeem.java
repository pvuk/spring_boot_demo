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

	@Field(value="REWARD_POINTS_REDEEM_ID", order = 1)
	@Id
	private String rewardPointsRedeemId;

	@Field(value="REWARD_CARD_ID", order = 2) private String rewardCardId;
	
	@Field(value="REWARDS_REDEEMED_THIS_MONTH", order = 3) private long rewardsRedeemedThisMonth;

	@Field(value="REWARDS_REDEEMED_TO", order = 4) private String rewardsRedeemedTo;
	
	@Field(value="REWARDS_REDEEMED_ON") private Date rewardsRedeemedOn;

	@Field(value="REWARDS_EXPIRE_THIS_MONTH", order = 5) private long rewardsExpireThisMonth;
	
	//SBI Bank Rewards Feature
	@Field(value="REWARDS_EXPIRE_NEXT_MONTH", order = 6) 		private long rewardsExpireNextMonth;
	@Field(value="REWARDS_EXPIRE_NEXT_THREE_MONTH", order = 7) 	private long rewardsExpireNextThreeMonth;

	@Field(value="POINTS_EXPIRE_NEXT_MONTH_ON", order = 8) 			private Date pointsExpireNextMonthOn;
	@Field(value="POINTS_EXPIRE_NEXT_THREE_MONTH_ON", order = 9) 	private Date pointsExpireNextThreeMonthOn;

	@Field(value="TOTAL_POINTS_EXPIRE", order = 10) private long totalPointsExpire;

	@Field(value="POINTS_EXPIRE_DETAILS", order = 11) private String pointsExpireDetails;
	
	@Field(value="COMMENT", order = 12) private String comment;
	
	@Field(value="CUSTOMER_ID", order = 13)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT", order = 14)
	private Boolean confirmPayment;
}
