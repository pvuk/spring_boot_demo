package com.spring.transaction.model;

import java.math.BigDecimal;

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
@Document(collection = "REWARD_POINTS_EARNED")
public class RewardPointsEarned {
	
	@Id
	private String rewardPointsEarnedId;
	
	private long rewardsEarnedOnOnlinePartners;
	
	private long rewardsEarnedOnAllOtherOnlineSpends;
	
	@NotEmpty(message = "Rewards Earned is required field.")
	private long rewardsEarned;
	
	@NotEmpty(message = "Point Value is required field.")
	private long eachPointValue;
	
	private BigDecimal rewardsAdjusted;
	
	private long rewardsEarnedForThisYear;
	
	private long rewardsEarnedFromTheCardIssueDate;
	
	@Field(value = "REWARD_CARD_ID")
	@NotNull(message = "Reward Card is required field.")
	private String rewardCardId;
	
	//HDFC CC feature
	private Long extraRewardsEligible;
	private Long extraRewardsEligibleFrom;
	private Long extraRewardsEligibleTill;
	
	@Field(value = "MAXIMUM_REWARD_POINTS_EARNED_PER_STATEMENT_CYCLE") private Long maximumRewardPointsEarnedPerStatementCycle;
	
	private String partnerShipId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
