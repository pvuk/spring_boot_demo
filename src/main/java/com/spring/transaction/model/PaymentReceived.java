package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_RECEIVED")
public class PaymentReceived {
	
	@Id
	private Long paymentReceivedId;
	
	@NotNull(message="Payment Received On is required field")
	private Date paymentReceivedOn;
}
