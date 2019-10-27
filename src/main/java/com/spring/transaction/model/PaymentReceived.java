package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_RECEIVED")
public class PaymentReceived {
	
	@Field(value="PAYMENT_RECEIVED_ID", order = 1)
	@Id
	private String paymentReceivedId;
	
	@Field(value="CUSTOMER_ID", order = 2)
	@NotNull(message="Payment Received From Customer is required field.")
	private String customerId;

	@Field(value="ACTUAL_AMOUNT", order = 3)
	private BigDecimal actualAmount;
	
	@Field(value="RECEIVED_AMOUNT", order = 4)
	@NotNull(message="Received Amount is required field.")
	private BigDecimal receivedAmount;
    
	@Field(value="REMAINING_AMOUNT", order = 5)
	private BigDecimal remainingAmount;

	@Field(value="PAYMENT_RECEIVED_ON", order = 6)
    @NotNull(message="Payment Received On is required field.")
	private Date paymentReceivedOn;
	
	@Field(value="PAYMENT_STATUS_ID", order = 7)
	private String paymentStatusId;
	
	@Field(value="CONFIRM_PAYMENT", order = 8)
	private Boolean confirmPayment;
	
	@Field(value = "REFERENCE_NO", order = 9)
	private String referenceNo;
	
	/*
	 * 1. Where the transaction is done(Payment Description).
	 */
	@Field(value = "TRANSACTION_DETAILS", order = 10)
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
    
}
