package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_HISTORY")
public class PaymentHistory {
	
	@Field(value="PAYMENT_HISTORY_ID", order = 1)
	@Id
	private String paymentHistoryId;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 2)
	private String paymentOnAccountId;
	
	@Field(value="PERIOD_ID", order = 3)
	private Long periodId;
	
	@Field(value="MONTH", order = 4)
	private Long month;
	
	@Field(value="YEAR", order = 5)
	private Long year;
}
