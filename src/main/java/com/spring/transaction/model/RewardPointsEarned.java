package com.spring.transaction.model;

import java.math.BigDecimal;
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
@Document(collection = "REWARD_POINTS_EARNED")
public class RewardPointsEarned {
	
	@Field(value="REWARD_POINTS_EARNED_ID", order = 1)
	@Id
	private String rewardPointsEarnedId;
	
	/*
	 * 1. if no records found previous balance should be 0 otherwise bring the last statement closing balance.
	 * 2. Trigger every month Thread cycle after statement date. Then user will know it in current statement.
	 * 3. If card is in inActive state don't run Thread cycle.
	 */
	@Field(value="previous_Balance", order = 2)
	@NotNull(message = "Previous Balance / Opening Balance is required field.")
	private long previousBalance;
	
	@Field(value="REWARDS_EARNED", order = 3)
	@NotNull(message = "Rewards Earned is required field.")
	private long rewardsEarned;
	
	/*
	 * 1. This Field is main for anyone of the following transactions Redeemed/Expired/Adjusted
	 * 2. All individual transactions will be shown in REWARD_POINTS_REDEEM
	 */
	@Field(value="REDEEMED_OR_EXPIRED_OR_ADJUSTED", order = 4)
	private BigDecimal redeemed_or_expired_or_adjusted;
	
	@Field(value="CLOSING_BALANCE", order = 5)
	private BigDecimal closingBalance;
	
	@Field(value="REWARD_POINTS_ADDED_ON", order = 6) private Date rewardPointsAddedOn;
	
	@Field(value = "REWARD_POINTS_REDEEM_ID", order = 7)
	private String rewardPointsRedeemId;
	
	@Field(value = "POINTS_EXPIRE_DETAILS", order = 8)
	private String pointsExpireDetails;

	/*
	 * 1. If user wish to see points in cash value EACH_POINT_VALUE value should be mandatory. 
	 */
	@Field(value="EACH_POINT_VALUE", order = 9)
	private long eachPointValue;
	
	/*
	 * if isRewardPointsCalculationAvailableInStatement is checked false disable
	 * fields: this year / From the card issue date
	 */
	@Field(value="IS_REWARD_POINTS_CALCULATION_AVAILABLE_IN_STATEMENT", order = 10)
	private Boolean isRewardPointsCalculationAvailableInStatement;
	
	@Field(value="REWARD_POINTS_FOR_THIS_STATEMENT", order = 11) 								private long rewardPointsForThisStatement;
	@Field(value="REWARD_POINTS_FOR_ONLINE_PARTNERS_FOR_THIS_STATEMENT", order = 12) 			private long rewardPointsForOnlinePartnersForThisStatement;
	@Field(value="REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS_FOR_THIS_STATEMENT", order = 13) 	private long rewardPointsForAllOtherOnlineSpendsForThisStatement;
	
	//SBI CC feature
	@Field(value="FOR_THIS_YEAR_REWARD_POINTS", order = 14) 										private long rewardPointsForThisYear;
	@Field(value="FOR_THIS_YEAR_REWARD_POINTS_FOR_ONLINE_PARTNERS", order = 15) 					private long rewardPointsForOnlinePartnersForThisYear;
	@Field(value="FOR_THIS_YEAR_REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS", order = 16) 			private long rewardPointsForAllOtherOnlineSpendsForThisYear;
	@Field(value="FROM_THE_CARD_ISSUE_DATE_REWARD_POINTS", order = 17) 								private long rewardPointsFromTheCardIssueDate;
	@Field(value="FROM_THE_CARD_ISSUE_DATE_REWARD_POINTS_FOR_ONLINE_PARTNERS", order = 18) 			private long rewardPointsForOnlinePartnersFromTheCardIssueDate;
	@Field(value="FROM_THE_CARD_ISSUE_DATE_REWARD_POINTS_FOR_ALL_OTHER_ONLINE_SPENDS", order = 19)	private long rewardPointsForAllOtherOnlineSpendsFromTheCardIssueDate;
	
	@Field(value = "REWARD_CARD_ID", order = 20)
	@NotNull(message = "Reward Card is required field.")
	private String rewardCardId;
	
	@Field(value = "STATEMENT_CREDIT_CARD_ID", order = 21)
	private String statementCreditCardId;
	
	/*
	 * 1. Extra / Bonus Points are under this category
	 */
	//HDFC CC feature
	@Field(value="EXTRA_REWARDS_ELIGIBLE", order = 22) 		private Long extraRewardsEligible;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_FROM", order = 23) private Long extraRewardsEligibleFrom;
	@Field(value="EXTRA_REWARDS_ELIGIBLE_TILL", order = 24) private Long extraRewardsEligibleTill;
	
	@Field(value = "MAXIMUM_REWARD_POINTS_EARNED_PER_STATEMENT_CYCLE", order = 25) private Long maximumRewardPointsEarnedPerStatementCycle;
	
	@Field(value="PARTNER_SHIP_ID", order = 26)
	private String partnerShipId;
	
	/*
	 * 1. If data is inserted / updated in REWARD_POINTS table, save / update in REWARD_POINTS_EARNED table.
	 * 2. Only one record allows per card, per statement in REWARD_POINTS and REWARD_POINTS_EARNED
	 */
	@NotNull(message = "Statement Reward Points is required field.")
	@Field(value="REWARD_POINTS_ID", order = 26)
	private String rewardPointsId;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/*
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS")
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
	
	@Field(value="CONFIRM_PAYMENT", order = 27)
	private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 28)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
