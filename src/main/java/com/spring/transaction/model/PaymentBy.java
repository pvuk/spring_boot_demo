package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_BY")
public class PaymentBy {
	
	@Id
	private String paymentById;
	
	@NotNull(message="UserId is required field.")
	private String userId;
	private String creditCardId;
	private String debitCardId;
	private String netBankingPaymentId;
	private String rewardPointsId;
	private String movieOfferId;
	private String cashPaymentId;
	
	@NotNull(message="Received From is required field.")
	private String receivedFromUserId;
	
	private boolean paymentShowToExpenser;
}
