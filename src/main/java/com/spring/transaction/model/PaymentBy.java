package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.validation.group.GroupCustomer;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_BY")
public class PaymentBy {
	
	@Id
	@Field(value="PAYMENT_BY_ID", order = 1)
	private String paymentById;
	
	/**
	 * 1. if payment received from more than one customer., we need to insert two records for single transaction.
	 */
	@Field(value="PAYMENT_RECEIVED_ID", order = 2)
	@NotNull(message = "Payment Received From Customer is required field.", groups = GroupCustomer.class)
	private List<String> paymentReceivedIds;
	
	@Field(value="CREDIT_CARD_PAYMENT_ID", order = 3)
	private String creditCardPaymentId;
	
	@Field(value="DEBIT_CARD_PAYMENT_ID", order = 4)
	private String debitCardPaymentId;
	
	@Field(value="NETBANKING_PAYMENT_ID", order = 5)
	private String netBankingPaymentId;
	
	@Field(value="PAYMENT_ON_REWARD_POINTSID", order = 6)
	private String paymentOnRewardPointsId;
	
	@Field(value="MOVIE_OFFER_ID", order = 7)
	private String movieOfferId;
	
	@Field(value="CASH_PAYMENT_ID", order = 8)
	private String cashPaymentId;
	
	@Field(value="WALLET_PAYMENT_ID", order = 9)
	private String walletPaymentId;
	
	@Field(value="EMI_PAYMENT_ID", order = 10)
	private String emiPaymentId;
	
	@Field(value="CHEQUE_PAYMENT_ID", order = 11)
	private String chequePaymentId;
	
	@Field(value="PAYMENT_SHOW_TO_EXPENSER", order = 12)
	private boolean paymentShowToExpenser;
	
	@Field(value = "COMMENT", order = 13)
	private String comment;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
	
	@Field("RATE_YOUR_PURCHASE_ID")
	private String rateYourPurchaseId;
	
	@Field(value = "OFFER_EXPENDITURE_ID")
	private String offerExpenditureId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
