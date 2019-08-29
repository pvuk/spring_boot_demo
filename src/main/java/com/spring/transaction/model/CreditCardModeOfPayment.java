package com.spring.transaction.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="CREDIT_CARD_MODE_OF_PAYMENT")
public class CreditCardModeOfPayment {
	
	private String creditCardModeOfPaymentId;
	private String modeOfPayment;
	private String type;
	private String convenienceFee;
	private List<CreditCardPaymentTurnAroundTime> creditCardPaymentTurnAroundTimeList;
}
