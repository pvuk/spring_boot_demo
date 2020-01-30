package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(value="CHEQUE_PAYMENT")
public class ChequePayment {

	@Id
	@Field(value = "CHEQUE_PAYMENT_ID", order = 1)
	private String chequePaymentId;
	
	/**
	 * 1. Display MM/DD/YYYY format at UI side
	 */
	private Date dateOfIssue;
	
	/**
	 * 1. Send alert 1 month / 2 week / 1 week / 4 days before to user when he/she didn't claim the amount 
	 */
	private Date validUpTo;
	
	private String payeeName;
	
	private String amountInWords;
	
	private String amountInFigures;
	
	private Long accountNumber;
	
	/**
	 * 1. Length / size of control should be 6 digits
	 */
	private Long chequeNumber;
	
	/**
	 * 1. Length / size of control should be 9 digits
	 */
	private Long micrCode;
	private Long accountId;
	private Long transactionCode;
	
	private String chequeReceivedLocation;
	
	/**
	 * 1. Display at UI side only Debit / Bounce
	 */
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
