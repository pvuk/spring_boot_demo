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

	@Id
	@Field(value = "REWARD_POINTS_REDEEM_ID", order = 1)					private String rewardPointsRedeemId;

	@Field(value = "REWARD_CARD_ID", order = 2) 							private String rewardCardId;
	
	@Field(value = "REWARDS_REDEEMED_THIS_MONTH", order = 3) 				private long rewardsRedeemedThisMonth;

	@Field(value = "REWARDS_REDEEMED_TO", order = 4) 						private String rewardsRedeemedTo;

	@Field(value = "REWARDS_REDEEMED_ON", order = 5) 						private Date rewardsRedeemedOn;
	
	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO", order = 6)								private String referenceNo;
	
	/**
	 * 1. Brief Description about Transaction related details
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS", order = 7) 						private String transactionDetails;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT", order = 8) 							private Boolean confirmPayment;
	
	@NotNull(message="Customer is required field.")
	@Field(value = "CUSTOMER_ID", order = 9)								private String customerId;
	
}
