package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_ON_ACCOUNT")
public class PaymentOnAccount {

	@Id
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 1)
	private String paymentOnAccountId;
	
	@Field(value="PAYMENT_RECEIVED_ID", order = 2)
	private String paymentReceivedId;
	
	@Field(value="PAYMENT_FAILED_ID", order = 3)
	private String paymentFailedId;
	
	@Field(value="PAYMENT_REFUND_ID", order = 4)
	private String paymentRefundId;
	
	@Field(value="PAYMENT_REVERSE_ID", order = 5)
	private String paymentReverseId;
	
	@Field(value="CASHBACK_ID", order = 6)
	private String cashbackId;
	
	@Field(value = "PAYMENT_BY_ID", order = 7)
	private String paymentById;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID", order = 8)
	private String paymentStatusId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 9)
	private String customerId;
}
