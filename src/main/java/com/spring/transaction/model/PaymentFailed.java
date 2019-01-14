package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_FAILED")
public class PaymentFailed {
	
	@BsonId
	private Long paymentFailedId;
	
	@NotNull(message="Payment Failed On is required field")
	private Date paymentFailedOn;
}
