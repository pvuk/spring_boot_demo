package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_REFUND")
public class PaymentRefund {
	
	@BsonId
	private Long paymentRefundId;
	
	@NotNull(message="Payment Refund On is required field")
	private Date paymentRefundOn;
}
