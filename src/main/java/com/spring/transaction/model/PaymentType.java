package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_TYPE_CODE")
public class PaymentType {
	
	@Id
	@Field(value = "payment_Type_Id")						private String paymentTypeId;
	
	@Field(value="CODE")
	@Indexed(unique=true)									private String code;
	
	@Field(value="POSITION") 								private Long position;
	
	@NotNull(message="Payment Type is required field.")
	@Field(value="DESCRIPTION") 							private String description;
}
