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
	
	@Field(value="DEBIT_CARD_PAYMENT_ID", order = 1)
	@Id private String debitCardPaymentId;

	@Field(value="DEBIT_CARD_ID", order = 2)
	@NotNull(message="Debit Card is required field.")
	private String debitCardId;
	
	@Field(value="AMOUNT", order = 3)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;
	
	@Field(value = "CUSTOMER_ID", order = 5)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
