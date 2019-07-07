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
	
	@Field(value="REWARD_POINTS_FOR_THIS_STATEMENT", order = 2)
	private long rewardPointsForThisStatement;
	
	@Field(value="REWARD_POINTS_FOR_ONLINE_PARTNERS_FOR_THIS_STATEMENT", order = 3)
	private long rewardPointsForOnlinePartnersForThisStatement;
	
	@Field(value="REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS_FOR_THIS_STATEMENT", order = 4)
	private long rewardPointsForAllOtherOnlineSpendsForThisStatement;
	
	/*
	 * if isRewardPointsCalculationAvailableInStatement is checked false disable
	 * fields: this year / From the card issue date
	 */
	@Field(value="IS_REWARD_POINTS_CALCULATION_AVAILABLE_IN_STATEMENT", order = 5)
	private Boolean isRewardPointsCalculationAvailableInStatement;
	
	//SBI CC feature
	@Field(value="REWARD_POINTS_FOR_THIS_STATEMENT", order = 6) 								private long rewardPointsForThisYear;
	@Field(value="REWARD_POINTS_FOR_ONLINE_PARTNERS_FOR_THIS_STATEMENT", order = 7) 			private long rewardPointsForOnlinePartnersForThisYear;
	@Field(value="REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS_FOR_THIS_STATEMENT", order = 8) 	private long rewardPointsForAllOtherOnlineSpendsForThisYear;
	@Field(value="REWARD_POINTS_FOR_THIS_STATEMENT", order = 9) 								private long rewardPointsFromTheCardIssueDate;
	@Field(value="REWARD_POINTS_FOR_ONLINE_PARTNERS_FOR_THIS_STATEMENT", order = 10) 			private long rewardPointsForOnlinePartnersFromTheCardIssueDate;
	@Field(value="REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS_FOR_THIS_STATEMENT", order = 11)	private long rewardPointsForAllOtherOnlineSpendsFromTheCardIssueDate;
	
	@Field(value="REWARDS_EARNED", order = 12)
	@NotEmpty(message = "Rewards Earned is required field.")
	private long rewardsEarned;
	
	@Field(value="EACH_POINT_VALUE", order = 13)
	@NotEmpty(message = "Each Point Value is required field.")
	private long eachPointValue;
	
	@Field(value="REWARDS_ADJUSTED", order = 14)
	private BigDecimal rewardsAdjusted;
	
	@Field(value="REWARDS_EARNED_FOR_THIS_YEAR", order = 15)
	private long rewardsEarnedForThisYear;
	
	@Field(value="REWARDS_EARNED_FROM_THE_CARD_ISSUE_DATE", order = 16)
	private long rewardsEarnedFromTheCardIssueDate;
	
	@Field(value = "REWARD_CARD_ID", order = 17)
	@NotNull(message = "Reward Card is required field.")
	private String rewardCardId;
	
	//HDFC CC feature
	@Field(value="EXTRA_REWARDS_ELIGIBLE", order = 18) 		private Long extraRewardsEligible;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_FROM", order = 19) private Long extraRewardsEligibleFrom;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_TILL", order = 20) private Long extraRewardsEligibleTill;
	
	@Field(value = "MAXIMUM_REWARD_POINTS_EARNED_PER_STATEMENT_CYCLE", order = 21) private Long maximumRewardPointsEarnedPerStatementCycle;
	
	@Field(value="PARTNER_SHIP_ID", order = 22)
	private String partnerShipId;
	
	/*
	 * 1. If data insert / update in REWARD_POINTS table save / update in REWARD_POINTS_EARNED table.
	 * 2. Only one record allows per card, per statement in REWARD_POINTS and REWARD_POINTS_EARNED
	 */
	@NotNull(message = "Statement Reward Points is required field.")
	@Field(value="REWARD_POINTS_ID", order = 23)
	private String rewardPointsId;
	
	@Field(value="CUSTOMER_ID", order = 24)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
