package com.spring.transaction.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CREDIT_CARD_BILL_PAYMENT_TYPE")
public class CreditCardBillPaymentType {
	
	private String creditCardBillPaymentTypeId;
	
	@NotNull(message = "Credit Card Bill Payment Mode is required filed.")
	@Field(value = "CREDIT_CARD_Bill_PAYMENT_MODE_ID")
	private String creditCardBillPaymentModeId;
	
	@NotNull(message = "Type is required field.")
	private String type;
	
	private String convenienceFee;
	
	private CreditCardBillPaymentTurnAroundTime ccBillPaymentTurnAroundTime;
	
	private List<CreditCardBillPaymentLoginAndAccess> ccBillPaymentLoginAndAccessList;
	
}
