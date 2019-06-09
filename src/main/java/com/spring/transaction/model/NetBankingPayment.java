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
	
	@Field(value="NET_BANKING_PAYMENT_ID", order = 1)
	@Id private String netBankingPaymentId;
	
	@Field(value = "TRANSACTION_ON", order = 2)
	private Date transactionOn;
	
	@DBRef private BankPayment bankAccount;
	
	@Field(value="AMOUNT", order = 3)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
}
