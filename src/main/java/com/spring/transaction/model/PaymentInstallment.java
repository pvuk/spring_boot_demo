package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "PAYMENT_INSTALLMENT")
public class PaymentInstallment {

	@Id
	@Field(value="PAYMENT_INSTALLMENT_ID", order = 1)					private String paymentInstallmentId;
	
	@Field(value="AMOUNT_DUE", order = 2)
	@NotNull(message="Amount Due is required field.")					private BigDecimal amountDue;
	
	@Field(value="DUE_DATE", order = 3) 								private Date dueDate;
	@Field(value="PREVIOUS_AMOUNT", order = 4) 							private BigDecimal previousAmount;
	@Field(value="AMOUNT_PAID", order = 5) 								private BigDecimal amountPaid;
	@Field(value="AMOUNT_PAID_ON", order = 6) 							private Date amountPaidOn;
	@Field(value="REMAINING_AMOUNT", order = 7) 						private BigDecimal remainingAmount;
	
	@Field(value="PAYMENT_INSTALLMENT_STATUS_ID", order = 8)			private String paymentInstallmentStatusId;
	
	@Field(value = "REFERENCE_NO")										private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Size(max = 3000)
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS", order = 9)					private String transactionDetails;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value="CONFIRM_PAYMENT", order = 10)							private Boolean confirmPayment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 11)								private String customerId;
	
}
