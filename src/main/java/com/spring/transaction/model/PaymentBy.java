package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.validation.group.GroupCustomer;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_BY")
public class PaymentBy {
	
	@Field(value="PAYMENTBY_ID", order = 1)
	@Id
	private String paymentById;
	
	@Field(value="PAYMENT_RECEIVED_FROM_CUSTOMER_ID", order = 2)
	@NotNull(message = "Payment Received From Customer is required field.", groups = GroupCustomer.class)
	private String customerId;
	
	@Field(value="CREDIT_CARD_PAYMENT_ID", order = 3)
	private String creditCardPaymentId;
	
	@Field(value="DEBIT_CARD_PAYMENT_ID", order = 4)
	private String debitCardPaymentId;
	
	@Field(value="NETBANKING_PAYMENT_ID", order = 5)
	private String netBankingPaymentId;
	
	@Field(value="REWARD_POINTS_REDEEM_ID", order = 6)
	private String rewardPointsRedeemId;
	
	@Field(value="MOVIE_OFFER_ID", order = 7)
	private String movieOfferId;
	
	@Field(value="CASH_PAYMENT_ID", order = 8)
	private String cashPaymentId;
	
	@Field(value="WALLET_PAYMENT_ID", order = 9)
	private String walletPaymentId;
	
	@Field(value="PAYMENT_SHOW_TO_EXPENSER", order = 10)
	private boolean paymentShowToExpenser;
	
	@Field(value = "COMMENT", order = 11)
	private String comment;
}
