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
	
	@Id
	@Field(value="PAYMENT_RECEIVED_ID", order = 1)
	private String paymentReceivedId;
	
	@Field(value="CUSTOMER_ID", order = 2)
	@NotNull(message="Payment Received From Customer is required field.")
	private String customerId;

	@Field(value="ACTUAL_AMOUNT", order = 3)
	private BigDecimal actualAmount;
	
	@NotNull(message="Received Amount is required field.")
	@Field(value="RECEIVED_AMOUNT", order = 4)
	private BigDecimal receivedAmount;
    
	@Field(value="REMAINING_AMOUNT", order = 5)
	private BigDecimal remainingAmount;

    @NotNull(message="Payment Received On is required field.")
    @Field(value="PAYMENT_RECEIVED_ON", order = 6)
	private Date paymentReceivedOn;
	
	@Field(value="PAYMENT_STATUS_ID", order = 7)
	private String paymentStatusId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value="CONFIRM_PAYMENT", order = 8)
	private Boolean confirmPayment;
	
	@Field(value = "REFERENCE_NO", order = 9)
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done(Payment Description).
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS", order = 10)
	private String transactionDetails;
    
}
