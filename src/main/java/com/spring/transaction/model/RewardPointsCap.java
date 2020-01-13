package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "REWARD_POINTS_CAP")
public class RewardPointsCap {

	@Id
	@Field(value = "REWARD_POINTS_CAP_ID")						private String rewardPointsCapId;
	
	@NotNull(message = "Payment By is required field.")
	@Field(value = "PAYMENT_BY_ID")								private String paymentById;
	
	@Field(value = "PAID_AMOUNT")								private BigDecimal paidAmount;
	@Field(value = "paid_On")									private Date paidOn;
	
	@Field(value = "REWARD_POINTS_EARNED")						private BigDecimal rewardPointsEarned;
	
	@Field(value="REWARD_POINTS_CATALOGUE_ID")					private String rewardPointsCatalogueId;
	
	@Field(value = "REWARD_POINTS_CAP_STATUS_ID")				private String rewardPointsCapStatusId;
	
	@Type(type="yes_no")
	@Field(value = "MONTHLY_CAP_REACHED")						private boolean monthlyCapReached;

	@Field(value="COMMENT")
	@Size(max = 3000)											private String comment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")									private String customerId;
	
}
