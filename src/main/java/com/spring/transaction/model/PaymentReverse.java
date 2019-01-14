package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REVERSE")
public class PaymentReverse {

	@BsonId
	private Long paymentReverseId;
	
	@NotNull(message="Payment Reverse On is required field")
	private Date paymentReverseOn;
}
