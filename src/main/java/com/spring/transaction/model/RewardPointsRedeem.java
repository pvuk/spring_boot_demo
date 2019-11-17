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

	@Field(value="REWARD_CARD_ID", order = 2) 							private String rewardCardId;
	
	@Field(value="REWARDS_REDEEMED_THIS_MONTH", order = 3) 				private long rewardsRedeemedThisMonth;

	@Field(value="REWARDS_REDEEMED_TO", order = 4) 						private String rewardsRedeemedTo;

	@Field(value="REWARDS_REDEEMED_ON", order = 5) 						private Date rewardsRedeemedOn;
	
	@Field(value = "REFERENCE_NO", order = 6)							private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS", order = 7) 					private String transactionDetails;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 */
	@Field(value = "CONFIRM_PAYMENT", order = 8) 						private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 9)
	@NotNull(message="Customer is required field.") 					private String customerId;
	
}
