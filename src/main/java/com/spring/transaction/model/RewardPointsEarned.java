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
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 1)
	@Id
	private String rewardPointsEarnedId;
	
	@Field(value="REWARDS_EARNED_ON_ONLINE_PARTNERS", order = 2)
	private long rewardsEarnedOnOnlinePartners;
	
	@Field(value="REWARDS_EARNED_ON_ALL_OTHER_ONLINE_SPENDS", order = 3)
	private long rewardsEarnedOnAllOtherOnlineSpends;
	
	@Field(value="REWARDS_EARNED", order = 4)
	@NotEmpty(message = "Rewards Earned is required field.")
	private long rewardsEarned;
	
	@Field(value="EACH_POINT_VALUE", order = 5)
	@NotEmpty(message = "Point Value is required field.")
	private long eachPointValue;
	
	@Field(value="REWARDS_ADJUSTED", order = 6)
	private BigDecimal rewardsAdjusted;
	
	@Field(value="REWARDS_EARNED_FOR_THIS_YEAR", order = 7)
	private long rewardsEarnedForThisYear;
	
	@Field(value="REWARDS_EARNED_FROM_THE_CARD_ISSUE_DATE", order = 8)
	private long rewardsEarnedFromTheCardIssueDate;
	
	@Field(value = "REWARD_CARD_ID", order = 9)
	@NotNull(message = "Reward Card is required field.")
	private String rewardCardId;
	
	//HDFC CC feature
	@Field(value="EXTRA_REWARDS_ELIGIBLE", order = 10) private Long extraRewardsEligible;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_FROM", order = 11) private Long extraRewardsEligibleFrom;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_TILL", order = 12) private Long extraRewardsEligibleTill;
	
	@Field(value = "MAXIMUM_REWARD_POINTS_EARNED_PER_STATEMENT_CYCLE", order = 13) private Long maximumRewardPointsEarnedPerStatementCycle;
	
	@Field(value="PARTNER_SHIP_ID", order = 14)
	private String partnerShipId;
	
	@Field(value="CUSTOMER_ID", order = 15)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
