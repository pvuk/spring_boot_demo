package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="Debit_Card_Payment")
public class DebitCardPayment {
	
	@Id
	@Field(value="DEBIT_CARD_PAYMENT_ID", order = 1)
	private String debitCardPaymentId;

	@NotNull(message="Debit Card is required field.")
	@Field(value="DEBIT_CARD_ID", order = 2)
	private String debitCardId;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;

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
	
	@NotNull(message="Customer is required field.")
	@Field(value = "CUSTOMER_ID", order = 5)
	private String customerId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;
}
