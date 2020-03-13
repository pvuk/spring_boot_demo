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
	@Field(value="CREDIT_CARD_BILL_PAYMENT_TURN_AROUND_TIME_ID", order = 1)		private String creditCardBillPaymentTurnAroundTimeId;
	
	@NotNull(message = "Credit Card Bill Payment Type is required field.")
	@Field(value = "CC_BILL_PAYMENT_TYPE")										private CreditCardBillPaymentType ccBillPaymentType;
	
	@Field(value = "AVAILABLE_LIMIT_RELEASE")									private String availableLimitRelease;
	
	@Field(value = "PAYMENT_CREDIT_TO_CARD_ACCOUNT")							private String paymentCreditToCardAccount;
	
	/**
	 * 1. Check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 6)										private String customerId;
}
