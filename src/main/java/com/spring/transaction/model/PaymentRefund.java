package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REFUND")
public class PaymentRefund {
	
	@Id
	@Field(value="PAYMENT_REFUND_ID", order = 1)
	private String paymentRefundId;
	
	@Field(value="REFUND_AMOUNT", order = 2)
	@NotNull(message="Refund Amount is required field.")
	private BigDecimal refundAmount;
	
	@NotNull(message="Payment Refund On is required field.")
	@Field(value="PAYMENT_REFUND_ON", order = 3)
	private Date paymentRefundOn;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 5)
	private String paymentOnAccountId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID", order = 6)
	private String paymentStatusId;
	
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Brief Description Transaction related details
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value="CONFIRM_PAYMENT", order = 7)
	private Boolean confirmPayment;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 8)
	private String customerId;
}
