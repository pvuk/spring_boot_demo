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
	
	@Field(value="PAYMENT_REFUND_ID", order = 1)
	@Id
	private String paymentRefundId;
	
	@Field(value="REFUND_AMOUNT", order = 2)
	@NotNull(message="Refund Amount is required field.")
	private BigDecimal refundAmount;
	
	@Field(value="PAYMENT_REFUND_ON", order = 3)
	@NotNull(message="Payment Refund On is required field.")
	private Date paymentRefundOn;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 5)
	private String paymentOnAccountId;
	
	@Field(value="PAYMENT_STATUS_ID", order = 6)
	private String paymentStatusId;
	
	@Field(value="CONFIRM_PAYMENT", order = 7)
	private Boolean confirmPayment;
	
	@Field(value="CUSTOMER_ID", order = 8)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
