package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(value = "RATE_YOUR_ANDROID_EXPERIENCE")
public class RateYourAndroidExperience {
	
	@Id
	@Field(value = "RATE_YOUR_ANDROID_EXPERIENCE_ID")
	private String rateYourAndroidExperienceId;
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	@Field(value = "RATING")
	private int rating;
	
	@Field(value = "RATING_ON")
	private Date ratingOn;
	
	@Field(value = "COMMENT")
	private String comment;
	
	@NotNull(message = "CustomerId is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
}
