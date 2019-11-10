package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UTILITY_PAYMENT_CODE")
public class UtilityPayment {

	@Id
	@Field(value = "UTILITY_PAYMENT_ID")					private String utilityPaymentId;
	
	@Field(value="CODE")
	@Indexed(unique=true)									private String code;
	
	@Field(value="POSITION") 								private Long position;
	
	@NotNull(message="Utility Payment is required field.")
	@Field(value="DESCRIPTION") 							private String description;
}
