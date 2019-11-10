package com.spring.transaction.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="LATE_PAYMENT")
public class LatePayment {

	@Id
	@Column(name = "LATE_PAYMENT_ID")							private String latePaymentId;
	
	@NotNull(message = "Fees And Charges is required field.")	private String feesAndChargesId;
	
	@NotNull(message = "Card Details is required field.")		private String cardDetailsId;
	
	@Field(value = "DESCRIPTION")								private String description;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")				private String customerId;
	
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")		private String paymentTypeId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
