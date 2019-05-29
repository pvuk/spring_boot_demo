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
	
	@Id private String creditCardPaymentId;
	
	@Field(value="CREDIT_CARD_ID")
	@NotNull(message="Credit Card is required field.")
	private String creditCardId;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON")
	private Date transactionOn;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
}
