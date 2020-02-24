package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_CARD_BILL_PAYMENT")
public class CreditCardBillPayment {
	
	@Id
	@Field(value="CREDIT_CARD_BILL_PAYMENT_ID", order = 1)
	private String creditCardBillPaymentId;
	
	@NotNull(message="Credit Card is required field.")
	@Field(value="CREDIT_CARD_ID", order = 2)
	private String creditCardId;
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID")
	private String creditCardStatementId;
	
	/**
	 * 1. CREDIT_CARD_STATEMENT_DATE should be display in DropDown as FromDate To ToDate [03-Jan-2020 To 02-Feb-2020](Reference: CREDIT_CARD_STATEMENT -> STATEMENT_PERIOD).
	 */
	@Field(value = "CREDIT_CARD_STATEMENT_DATE")
	private String creditCardStatementDate;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 5)
	private String customerId;
	
	/**
	 * 1. Same login user not authorize to CONFIRM_PAYMENT.
	 * 2. Default value should be null.
	 * 3. CONFIRM_PAYMENT in the sense NetBanking / UPI / CASH / DebitCard / Wallet / Cheque. 
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@Field(value = "CONFIRM_CREDIT_CARD_CREDIT_AMOUNT")
	private Boolean confirmCreditCardCreditAmount;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	/**
	 * CREDIT_CARD_STATEMENT STATEMENT_DATE
	 */
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;
}
