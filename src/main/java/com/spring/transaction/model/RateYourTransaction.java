package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(value = "RATE_YOUR_TRANSACTION")
public class RateYourTransaction {
	
	@Id
	@Field(value="RATE_YOUR_TRANSACTION_ID", order = 1)
	private String rateYourTransactionId;
	
	@Field(value = "PAYMENT_BY_ID")
	private String paymentById;
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	@Field(value = "RATING")
	private int rating;
	
	@Field(value = "RATING_ON")
	private Date ratingOn;
	
	@Field(value = "COMMENT")
	private String comment;
	

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	private String customerId;
}
