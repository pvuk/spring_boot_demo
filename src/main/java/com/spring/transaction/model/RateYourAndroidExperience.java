package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(value = "RATE_YOUR_ANDROID_EXPERIENCE")
public class RateYourAndroidExperience {
	
	private String rateYourAndroidExperienceId;
	
	/**
	 * 1. Once stars are selected, it should be saved automatically.
	 */
	private int rating;
	private Date ratingOn;
	private String comment;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	private String customerId;
}
