package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_ON_REWARD_POINTS")
public class PaymentOnRewardPoints {
	
	@Id
	@Field(value = "PAYMENT_ON_REWARD_POINTS_ID", order = 1)				private String paymentOnRewardPointsId;
	
	@Field(value = "PAYMENT_BY_ID", order = 2)								private String paymentById;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)										private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)								private Date transactionOn;
	
	@NotNull(message = "Card is required field.")
	@Field(value = "CARD_DETAILS_ID", order = 5)							private String cardDetailsId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT", order =  6)							private Boolean confirmPayment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 7)									private String customerId;
	
	@Field(value = "REWARD_POINTS_CAP_ID")									private String rewardPointsCapId;
}
