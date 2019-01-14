package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_ON_ACCOUNT")
public class PaymentOnAccount {

	@BsonId
	private Long paymentOnAccountId;
	
	@NotNull(message="Payment Amount is required field")
	private BigDecimal paymentAmount;
	
	private Long paymentReceivedId;
	
	private Long paymentFailedId;
	
	private Long paymentRefundId;
	
	private Long paymentReverseId;
	
	private Long cashbackId;
}
