package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="CREDIT_CARD_PAYMENT_TYPE")
public class CreditCardPaymentType {
	
	private String creditCardPaymentTypeId;
	
	@NotNull(message = "Credit Card Mode Of Payment is required filed.")
	private String creditCardModeOfPaymentId;
	
	@NotNull(message = "Type is required field.")
	private String type;
	
	private String convenienceFee;
	
	private CreditCardPaymentTurnAroundTime ccPaymentTurnAroundTime;
	
	private List<CreditCardPaymentLoginAndAccess> ccPaymentLoginAndAccessList;
	
}
