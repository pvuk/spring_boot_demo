package com.spring.transaction.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "REWARD_POINTS_REDEEM")
public class RewardPointsRedeem {

	@Id
	private String rewardPointsRedeemId;

	private long rewardsRedeemedThisMonth;

	private long rewardsRedeemedTo;

	private long rewardsAdjusted;

	private long rewardsExpireThisMonth;

	private Date pointsExpireOn;

	private long totalPointsExpire;

	private String pointsExpireDetails;
	
	private String rewardCardId;
}
