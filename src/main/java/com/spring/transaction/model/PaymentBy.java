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
	
	@Field(value="PAYMENT_BY_ID", order = 1)
	@Id
	private String paymentById;
	
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
	
	@Field("RATE_YOUR_PURCHASE_ID")
	private String rateYourPurchaseId;
}
