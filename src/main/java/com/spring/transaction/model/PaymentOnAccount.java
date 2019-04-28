package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PAYMENT_ON_ACCOUNT")
public class PaymentOnAccount {

	@Id
	private String paymentOnAccountId;
	
	@NotNull(message="Payment Amount is required field")
	private BigDecimal paymentAmount;
	
	private String paymentReceivedId;
	
	private String paymentFailedId;
	
	private String paymentRefundId;
	
	private String paymentReverseId;
	
	private String cashbackId;
}
