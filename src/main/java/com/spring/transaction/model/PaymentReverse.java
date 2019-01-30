package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REVERSE")
public class PaymentReverse {

	@Id
	private Long paymentReverseId;
	
	@NotNull(message="Payment Reverse On is required field")
	private Date paymentReverseOn;
	
	private String description;
}
