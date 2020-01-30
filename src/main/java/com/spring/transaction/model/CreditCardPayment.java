package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_CARD_PAYMENT")
public class CreditCardPayment {
	
	@Id
	@Field(value="CREDIT_CARD_PAYMENT_ID", order = 1)
	private String creditCardPaymentId;
	
	@NotNull(message="Credit Card is required field.")
	@Field(value="CREDIT_CARD_ID", order = 2)
	private String creditCardId;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 5)
	private String customerId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;
}
