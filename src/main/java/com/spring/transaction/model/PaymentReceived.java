package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_RECEIVED")
public class PaymentReceived {
	
	@Id
	private String paymentReceivedId;
	
	@NotNull(message="Received Amount is required field")
	private BigDecimal receivedAmount;
	
	@NotNull(message="Payment Received On is required field")
	private Date paymentReceivedOn;
}
