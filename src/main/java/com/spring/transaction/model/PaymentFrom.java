package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_FROM_CODE")
public class PaymentFrom {

	@Id
	@Field(value = "PAYMENT_FROM_ID")					private String paymentFromId;
	
	@Field(value="CODE")
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Payment From is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
