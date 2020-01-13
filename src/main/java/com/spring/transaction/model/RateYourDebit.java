package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 1. Rating is given to Lender by Borrower.
 * 2. Selft rating is not possible. 
 * 
 * @author Priyanka
 * 
 * 3. Check in database how column names are created., if @Field not mentioned on variable declaration.
 *
 */
@Data
@Document(value = "RATE_YOUR_DEBIT")
public class RateYourDebit {
	
	@Id
	private String rateYourDebitId;
	
	/**
	 * NOTE: Check in database how column names are created., if @Field not mentioned on variable declaration.
	 */
	private String paymentById;
	
	/**
	 * 1. Debited from
	 */
	public String borrowerId;
	
	/**
	 * 1. Credited to
	 */
	private String lenderId;
	
	private int overalRatingScore;
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	private int rating;
	private Date ratingOn;
	private String comment;
	
	@Type(type="yes_no")
	private boolean approveRating;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	private String customerId;
}
