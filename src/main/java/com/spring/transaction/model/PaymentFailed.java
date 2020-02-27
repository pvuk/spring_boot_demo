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
	
	@Id
	@Field(value="PAYMENT_FAILED_ID", order = 1)
	private String paymentFailedId;
	
	@NotNull(message="Failed Amount is required field.")
	@Field(value="FAILED_AMOUNT", order = 2)
	private BigDecimal failedAmount;
	
	@NotNull(message="Payment Failed On is required field.")
	@Field(value="PAYMENT_FAILED_ON", order = 3)
	private Date paymentFailedOn;
	
	@Field(value="PAYMENT_ON_ACCOUNT_ID", order = 4)
	private String paymentOnAccountId;
	
	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Brief Description about Transaction related details
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	@Field(value="IS_PAYMENT_ROLLBACK_TO_SOURCE")
	private Boolean isPaymentRollbackToSource;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")
	private String customerId;
}
