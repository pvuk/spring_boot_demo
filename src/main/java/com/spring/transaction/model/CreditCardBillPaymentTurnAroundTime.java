package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * Source: <a href="https://www.rblbank.com/credit-card-payments">Make your Credit Card Payments Instantly</a>
 * 
 * @author venkataudaykiranp
 * 
 *
 */
@Data
@Document(collection="CREDIT_CARD_BILL_PAYMENT_TURN_AROUND_TIME")
public class CreditCardBillPaymentTurnAroundTime {
	
	@Id
	private String creditCardBillPaymentTurnAroundTimeId;
	
	@NotNull(message = "Credit Card Bill Payment Type is required field.")
	private CreditCardBillPaymentType ccBillPaymentType;
	
	private String availableLimitRelease;
	private String paymentCreditToCardAccount;
	
	/**
	 * 1. Check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
