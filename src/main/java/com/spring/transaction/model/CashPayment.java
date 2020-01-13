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

	@Id
	@Field(value = "CASH_PAYMENT_ID")
	private String cashPaymentId;
	
	@Field(value = "ACTUAL_AMOUNT")
	private BigDecimal actualAmount;
	
	@Field(value = "PAID_AMOUNT")
    private BigDecimal paidAmount;
	
	@Field(value = "REMAINING_AMOUNT")
    private BigDecimal remainingAmount;
	
	@Field(value = "PAID_ON")
    private Date paidOn;
	
	@Field(value = "RECIEVED_AMOUNT")
    private BigDecimal recievedAmount;
	
	@Field(value = "RECIEVED_ON")
    private Date recievedOn;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	/**
	 * 1. Same login user not right to confirm the payment.
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")
	private String customerId;
}
