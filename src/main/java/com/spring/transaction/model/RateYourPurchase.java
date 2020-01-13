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
	
	@Field("PAYMENT_BY_ID")
	private String paymentById;
	
	@Field("RATE_YOUR_TRANSACTION_ID")
	private String rateYourTransactionId;
	
	@Field("RATE_YOUR_ANDROID_EXPERIENCE_ID")
	private String rateYourAndroidExperienceId;
	
	@Field("RATE_YOUR_CREDIT_ID")
	private String rateYourCreditId;
	
	@Field("RATE_YOURDEBIT_ID")
	private String rateYourDebitId;
	
	@Field("RATE_YOUR_IOS_EXPERIENCE_ID")
	private String rateYourIOSExperienceId;
	
	@Field("RATE_YOUR_WEB_EXPERIENCE_ID")
	private String rateYourWebExperienceId;
	
	@NotNull(message = "CustomerId is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
}
