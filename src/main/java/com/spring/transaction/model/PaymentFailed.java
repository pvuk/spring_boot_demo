package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_FAILED")
public class PaymentFailed {
	
	@Field(value="PAYMENT_FAILED_ID", order = 1)
	@Id
	private String paymentFailedId;
	
	@Field(value="FAILED_AMOUNT", order = 2)
	@NotNull(message="Failed Amount is required field.")
	private BigDecimal failedAmount;
	
	@Field(value="PAYMENT_FAILED_ON", order = 3)
	@NotNull(message="Payment Failed On is required field.")
	private Date paymentFailedOn;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 4)
	private String paymentOnAccountId;
	
	@Field(value="IS_PAYMENT_ROLLBACK_TO_SOURCE")
	private Boolean isPaymentRollbackToSource;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
