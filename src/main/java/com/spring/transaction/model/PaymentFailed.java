package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_FAILED")
public class PaymentFailed {
	
	@Id
	private Long paymentFailedId;
	
	@NotNull(message="Payment Failed On is required field")
	private Date paymentFailedOn;
}
