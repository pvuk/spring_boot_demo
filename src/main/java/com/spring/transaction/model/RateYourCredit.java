package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
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
	
	@Id
	@Field(value = "RATE_YOUR_CREDIT_ID")
	private String rateYourCreditId;
	
	@Field(value = "PAYMENT_BY_ID")
	private String paymentById;
	
	/**
	 * 1. Credited from
	 */
	@Field(value = "LENDER_ID")
	private String lenderId;
	
	/**
	 * 1. Debited to
	 */
	@Field(value = "BORROWER_ID")
	public String borrowerId;
	
	@Field(value = "OVERAL_RATING_SCORE")
	private int overalRatingScore;
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	@Field(value = "RATING")
	private int rating;
	
	@Field(value = "RATING_ON")
	private Date ratingOn;
	
	@Field(value = "COMMENT")
	private String comment;
	
	@Type(type="yes_no")
	@Field(value = "APPROVE_RATING")
	private boolean approveRating;
	
	@NotNull(message = "CustomerId is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
}
