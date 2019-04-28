package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REFUND")
public class PaymentRefund {
	
	@Id
	private String paymentRefundId;
	
	@NotNull(message="Refund Amount is required field")
	private BigDecimal refundAmount;
	
	@NotNull(message="Payment Refund On is required field")
	private Date paymentRefundOn;
}
