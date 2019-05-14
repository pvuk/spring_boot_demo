package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_HISTORY")
public class PaymentHistory {
	
	@Id
	private String paymentHistoryId;
	
	private String paymentOnAccountId;
	
	private Long periodId;
	
	private Long month;
	
	private Long year;
}
