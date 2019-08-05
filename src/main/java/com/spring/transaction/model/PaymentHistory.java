package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * PAYMENT_HISTORY is used for monthly payments towards Credit Card Bill
 *
 */
@Data
@Document(collection="PAYMENT_HISTORY")
public class PaymentHistory {
	
	@Field(value="PAYMENT_HISTORY_ID", order = 1)
	@Id
	private String paymentHistoryId;
	
	@NotNull(message="Payment On Account is required field.")
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 2)
	private String paymentOnAccountId;
	
	/*
	 * 1. Count 1 period as 1 year.
	 * 2. Every year period will increase to +1.
	 */
	@Field(value="PERIOD_ID", order = 3)
	private Long periodId;
	
	@Field(value="MONTH", order = 4)
	private Long month;
	
	@Field(value="YEAR", order = 5)
	private Long year;
	
	@NotNull(message = "Paid On is required field.")
	@Field(value = "PAID_ON")
	private Date paidOn;
	
	@NotNull(message="MileStone Achievement is required field.")
	@Field(value = "MILESTONE_ACHIEVEMENT_ID")
	private Long mileStoneAchievementId;
	
	@Field(value="COMMENT", order = 6)
	@Size(max = 3000)
	private String comment;
	
	@Field(value="CUSTOMER_ID", order = 7)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
