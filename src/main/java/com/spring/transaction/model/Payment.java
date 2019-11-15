package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT")
public class Payment {
	
	@Id
	@Field(value = "PAYMENT_ID")								private String paymentId;
	@Field(value = "PAYMENT_FROM_ID")							private String paymentFromId;
	@Field(value = "PAYMENT_TO_ID")								private String paymentToId;
	
	/**
	 * 1. if payment is single / multiple PARENT_PAYMENT_ID is root of all transactions.
	 * 
	 */
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
	
	/**
	 * 1. If fuel cashback / bank credited, this payment is refer as bank source(Ex: Yesbank, SBI CC)
	 */
	@Field(value = "FROM_SOURCE")								private Boolean fromSource;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")				private String customerId;
}
