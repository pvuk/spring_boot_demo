package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "REWARD_POINTS_EARNED")
public class RewardPointsEarned {
	
	@Id
	private String rewardPointsEarnedId;
	
	private long rewardsEarnedOnOnlinePartners;
	
	private long rewardsEarnedOnAllOtherOnlineSpends;
	
	@NotEmpty(message = "Rewards Earned is required field")
	private long rewardsEarned;
	
	private BigDecimal rewardsAdjusted;
	
	private long rewardsEarnedForThisYear;
	
	private long rewardsEarnedFromTheCardIssueDate;
	
	private String rewardCardId;
}
