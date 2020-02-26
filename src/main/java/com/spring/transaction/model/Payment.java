package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT")
public class Payment {
	
	@Id
	@Field(value = "PAYMENT_ID")								private String paymentId;
	
	/**
	 * 1. If Booking ticket from bookmyshow.com PAYMENT_SOURCE_ID is bookmyshow and PAYMENT_FROM_ID is ICICI Debit Card and PAYMENT_TO_ID bookmyshow
	 */
	@Field(value = "PAYMENT_SOURCE_ID")							private String paymentSourceId;
	
	/**
	 * 1. Some times user need to pay using Multiple Options. So PAYMENT_FROM_ID having two records i.e., Wallet Balance + DC / CC / NetBanking / UPI payment. 
	 */
	@Field(value = "PAYMENT_FROM_ID")							private List<String> paymentFromId;
	@Field(value = "PAYMENT_TO_ID")								private String paymentToId;
	
	/**
	 * 1. if payment is single / multiple PAYMENT_BY_ID is root for all transactions.
	 * 
	 */
	@NotNull(message = "Payment By is required field.")
	@Field(value = "PAYMENT_BY_ID")								private String paymentById;
	
	/**
	 * 1. If fuel cashback / bank credited, this payment is refer as bank source(Ex: Yesbank, SBI CC)
	 */
	@Type(type="yes_no")
	@Field(value = "FROM_SOURCE")								private Boolean fromSource;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")									private String customerId;
}
