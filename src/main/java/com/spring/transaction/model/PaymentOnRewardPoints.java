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
	
	@Field(value = "PAYMENT_ON_REWARD_POINTS_ID", order = 1)
	@Id private String paymentOnRewardPointsId;
	
	@Field(value = "PAYMENT_BY_ID", order = 2)
	private String paymentById;
	
	@Field(value="AMOUNT", order = 3)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;
	
	@Field(value = "REWARD_CARD_ID", order = 5)
	private String rewardCardId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 */
	@Field(value = "CONFIRM_PAYMENT", order =  6)
	private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 7)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
