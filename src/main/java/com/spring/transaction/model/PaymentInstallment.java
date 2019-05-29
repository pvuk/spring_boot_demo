package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_INSTALLMENT")
public class PaymentInstallment {

	@Id
	private String paymentInstallmentId;
	
	@NotNull
	private BigDecimal amountDue;
	
	private Date dueDate;
	private BigDecimal previousAmount;
	private BigDecimal amountPaid;
	
	@Size(max = 3000)
	private String comment;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
	
}
