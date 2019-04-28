package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CARD_PAYMENT")
public class CardPayment {
	
	@Id
	private String cardPaymentId;
	private String creditCardId;
	private String debitCardId;
	private String netBankingPaymentId;
	private String rewardPointsId;
	private String movieOfferId;
}
