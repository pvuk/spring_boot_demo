package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 1. Rating given to Borrower by Lender.
 * 2. Self rating is not possible.
 * 3. Check in database how column names are created., if @Field not mentioned on variable declaration.
 * 
 * @author Priyanka
 * @author venkataudaykiranp
 * @Date Thu 27-Feb-2020 15:27
 */
@Data
@Document(collection ="RATE_YOUR_PURCHASE")
public class RateYourPurchase {
	
	@BsonId
	@Field("RATE_YOUR_PURCHASE_ID")
	private String rateYourPurchaseId;
	
	/**
	 * NOTE: Check in database how column names are created., if @Field not mentioned on variable declaration.
	 */
	@Field("PAYMENT_BY_ID")
	private String paymentById;
	
	@Field(value = "RATE_YOUR_EXPERIENCE_ID")
	private String rateYourExperienceId;
	
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
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	@Field(value = "RATING")
	private int rating;
	
	@Field(value = "RATING_ON")
	private Date ratingOn;
	
	/**
	 * 1. Group By RATE_YOUR_EXPERIENCE_ID and update with individual experience.
	 */
	@Field(value = "OVERAL_RATING_SCORE")
	private int overalRatingScore;
	
	@Field(value = "COMMENT")
	private String comment;
	
	/**
	 * 1. Every FEED_BACK submitted by CUSTOMER_ID read carefully.
	 * 2. If FEED_BACK gives reputation implement the feature if not available.
	 */
	@Field(value = "FEED_BACK")
	private String feedBack;
	
	/**
	 * 1. Only Admin can APPROVE_RATING 
	 */
	@Type(type="yes_no")
	@Field(value = "APPROVE_RATING")
	private boolean approveRating;
	

	@NotNull(message = "CustomerId is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
}
