package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REVERSE")
public class PaymentReverse {

	@Field(value="PAYMENT_REVERSE_ID", order = 1)
	@Id
	private String paymentReverseId;
	
	@Field(value="REVERSE_AMOUNT", order = 2)
	@NotNull(message="Reverse Amount is required field.")
	private BigDecimal reverseAmount;
	
	@Field(value="PAYMENT_REVERSE_ON", order = 3)
	@NotNull(message="Payment Reverse On is required field.")
	private Date paymentReverseOn;
	
	@Field(value="DESCRIPTION", order = 4)
	private String description;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 5)
	private String paymentOnAccountId;
	
	@Field(value="PAYMENT_STATUS_ID", order = 6)
	private String paymentStatusId;
	
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS")
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
	
	@Field(value="CONFIRM_PAYMENT", order = 7)
	private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 8)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
