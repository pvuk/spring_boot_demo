package com.spring.transaction.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="LATE_PAYMENT")
public class LatePayment {

	@Column(name = "LATE_PAYMENT_ID")
	@Id
	private String latePaymentId;
	
	@NotNull(message = "Fees And Charges is required field.")
	private String feesAndChargesId;
	
	@NotNull(message = "Card Details is required field.")
	private String cardDetailsId;
	
	private String description;
}
