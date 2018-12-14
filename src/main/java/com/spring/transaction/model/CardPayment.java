package com.spring.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CARD_PAYMENT")
public class CardPayment {
	
	@Id
	private Long cardDetailsId;
	private Long creditCardId;
	private Long debitCardId;
	private long rewardPointsId;
	private Long movieOfferId;
	
}
