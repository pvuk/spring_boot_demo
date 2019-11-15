package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * Source: <a href="https://www.rblbank.com/credit-card-payments>Make your Credit Card Payments Instantly</a>
 *
 */
@Data
@Document(collection="CREDIT_CARD_PAYMENT_TURN_AROUND_TIME")
public class CreditCardPaymentTurnAroundTime {
	
	@Id
	private String creditCardPaymentTurnAroundTimeId;
	
	@NotNull(message = "Credit Card Payment Type is required field.")
	private CreditCardPaymentType ccPaymentType;
	
	private String availableLimitRelease;
	private String paymentCreditToCardAccount;
	
	/**
	 * 1. check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
