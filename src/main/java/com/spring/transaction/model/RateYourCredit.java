package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 1. Rating given to Borrower by Lender.
 * 2. Self rating is not possible.
 * 
 * @author Priyanka
 *
 */
@Data
@Document(value = "RATE_YOUR_CREDIT")
public class RateYourCredit {
	
	private String rateYourCreditId;
	
	private String paymentById;
	
	/*
	 * Credited from
	 */
	private String lenderId;
	
	/*
	 * Debited to
	 */
	public String borrowerId;
	
	private int overalRatingScore;
	
	/*
	 * 1. once stars are selected, it should be saved automatically.
	 */
	private int rating;
	private Date ratingOn;
	private String comment;
	
	private boolean approveRating;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	private String customerId;
}
