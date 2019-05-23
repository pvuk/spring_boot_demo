package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_INSTALLMENT_CODE")
public class PaymentInstallmentStatus {
	
	@Id
	private String paymentInstallmentStatusId;
	
	@Indexed(unique = true)
	@NotBlank(message = "Code is required field.")
	private String code;
	private int position;
	
	@NotEmpty(message = "Status is required field.")
	private String description;
}
