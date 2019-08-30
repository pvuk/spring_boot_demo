package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CREDIT_CARD_MODE_OF_PAYMENT")
public class CreditCardModeOfPayment {
	
	@Id
	private String creditCardModeOfPaymentId;
	
	@NotNull(message="Credit Card is required field.")
	private CreditCard creditCard;
	
	@NotNull(message="Credit Card Payment Type is required field.")
	private List<CreditCardPaymentType> ccPaymentTypeList;
	
	@Field(value="MODE_OF_PAYMENT")
	private String modeOfPayment;
	
	/*
	 * <p>* Available Limit Release is subject to bank’s policies and discretion.<p>
	 */
	private String noteAvailableLimitRelease;
	/*
	 * <p>* Turnaround Time is mentioned in Business Days.</p>
	 */
	private String noteTurnaroundTime;
	
	/*
	 * check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
