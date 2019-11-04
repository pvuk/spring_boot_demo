package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection ="RATE_YOUR_PURCHASE")
public class RateYourPurchase {
	
	@BsonId
	@Field("RATE_YOUR_PURCHASE_ID")
	private String rateYourPurchaseId;
	
	private String paymentById;
	
	private String rateYourTransactionId;
	
	private String rateYourAndroidExperienceId;
	
	private String rateYourCreditId;
	
	private String rateYourDebitId;
	
	private String rateYourIOSExperienceId;
	
	private String rateYourWebExperienceId;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	private String customerId;
}
