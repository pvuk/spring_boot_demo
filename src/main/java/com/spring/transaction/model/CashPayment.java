package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
/**
 * 
 * @author Priyanka P
 *
 */
@Data
@Document(collection="CASH_PAYMENT")
public class CashPayment {

	@Id private String cashPaymentId;
	private BigDecimal actualAmount;
    private BigDecimal paidAmount;
    private BigDecimal remainingAmount;
    private Date paidOn;
    private BigDecimal recievedAmount;
    private Date recievedOn;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/*
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS")
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
	
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
