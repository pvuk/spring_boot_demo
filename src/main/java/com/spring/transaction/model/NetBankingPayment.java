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
	
	@Id
	@Field(value="NET_BANKING_PAYMENT_ID", order = 1)
	private String netBankingPaymentId;
	
	@Field(value = "TRANSACTION_ON", order = 2)
	private Date transactionOn;
	
	@DBRef private BankPayment bankAccount;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)
	private BigDecimal amount;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT", order =  4)
	private Boolean confirmPayment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 5)
	private String customerId;
	
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
