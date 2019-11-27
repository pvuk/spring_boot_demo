package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_INSTALLMENT_STATUS_CODE")
public class PaymentInstallmentStatus {
	
	@Field(value="PAYMENT_INSTALLMENT_STATUS_ID", order = 1)
	@Id
	private String paymentInstallmentStatusId;
	
	@Field(value="CODE", order = 2)
	@Indexed(unique = true)
	@NotNull(message = "Code is required field.")
	private String code;
	
	@Field(value="POSITION", order = 3) private int position;
	
	@Field(value="DESCRIPTION", order = 4)
	@NotNull(message = "Status is required field.")
	private String description;
}
