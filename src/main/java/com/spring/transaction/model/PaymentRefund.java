package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REFUND")
public class PaymentRefund {
	
	@Id
	private Long paymentRefundId;
	
	@NotNull(message="Payment Refund On is required field")
	private Date paymentRefundOn;
}
