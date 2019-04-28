package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REVERSE")
public class PaymentReverse {

	@Id
	private String paymentReverseId;
	
	@NotNull(message="Reverse Amount is required field")
	private BigDecimal reverseAmount;
	
	@NotNull(message="Payment Reverse On is required field")
	private Date paymentReverseOn;
	
	private String description;
}
