package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "NETBANKING_PAYMENT")
public class NetBankingPayment {
	
	@Id private String netBankingPaymentId;
	
	@Field(value = "TRANSACTION_ON")
	private Date transactionOn;
	
	@DBRef private BankPayment bankAccount;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
}
