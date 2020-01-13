package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_TO_CODE")
public class PaymentTo {

	@Id
	@Field(value = "PAYMENT_TO_ID")						private String paymentToId;
	
	@Indexed(unique=true)
	@Field(value="CODE")								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Payment To is required field.")
	@Field(value="DESCRIPTION") 						private String description;
}
