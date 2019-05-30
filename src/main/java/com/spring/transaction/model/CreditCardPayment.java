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
	
	@Field(value="CREDIT_CARD_PAYMENT_ID", order = 1)
	@Id private String creditCardPaymentId;
	
	@Field(value="CREDIT_CARD_ID", order = 2)
	@NotNull(message="Credit Card is required field.")
	private String creditCardId;
	
	@Field(value="AMOUNT", order = 3)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;
	
	@Field(value="CUSTOMER_ID", order = 5)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
