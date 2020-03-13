package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_STATUS_CODE")
public class PaymentStatus {
	
	@Id
	@Field(value="PAYMENT_STATUS_ID", order = 1)							private String paymentStatusId;
	
	@Indexed(unique = true)
	@NotNull(message = "Code is required field.")
	@Field(value="CODE", order = 2)											private String code;
	
	@Field(value="POSITION", order = 3) 									private int position;
	
	@NotNull(message = "Status is required field.")
	@Field(value="DESCRIPTION", order = 4)									private String description;
}
