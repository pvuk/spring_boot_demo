package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="Debit_Card_Payment")
public class DebitCardPayment {
	
	@Id private String debitCardPaymentId;

	@Field(value="DEBIT_CARD_ID")
	@NotNull(message="Debit Card is required field.")
	private String debitCardId;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON")
	private Date transactionOn;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
}
