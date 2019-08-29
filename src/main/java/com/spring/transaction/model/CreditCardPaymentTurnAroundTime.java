package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * Source: <a href="https://www.rblbank.com/credit-card-payments>Make your Credit Card Payments Instantly</a>
 *
 */
@Data
@Document(collection="CreditCardPaymentTurnAroundTime")
public class CreditCardPaymentTurnAroundTime {
	
	@Id
	private String creditCardPaymentTurnAroundTimeId;
	
	@NotNull(message = "Credit Card Mode Of Payment is required field.")
	private String creditCardModeOfPaymentId;
	
	private String availableLimitRelease;
	private String paymentCreditToCardAccount;
	/*
	 * 1. This field contains links and some additional information regarding payment
	 * 2. Contains Links to redirect payment gateways.
	 */
	private String loginAndAccess;
	
	/*
	 * 1. This field contains image data in database or image link reference to display on UI
	 */
	private String loginAndAccessImage;
	
	private String comment;
}
