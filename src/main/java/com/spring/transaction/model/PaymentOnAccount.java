package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_ON_ACCOUNT")
public class PaymentOnAccount {

	@Id
	private String paymentOnAccountId;
	
	private String paymentReceivedId;
	
	private String paymentFailedId;
	
	private String paymentRefundId;
	
	private String paymentReverseId;
	
	private String cashbackId;
}
