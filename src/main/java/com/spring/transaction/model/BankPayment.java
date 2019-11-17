package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_PAYMENT")
public class BankPayment {

	@Field(value = "BANK_PAYMENT_ID", order = 1)
	@Id
	private String bankPaymentId;

	@Field(value = "BANK_CODE", order = 2)
	@NotNull(message = "Bank Can't be empty.")
	@DBRef
	private Bank bank;

	@Field(value = "ACCOUNT_NUMBER", order = 3)
	@NotNull(message = "Account Number is required field.")
	private BigDecimal accountNumber;

	@Field(value = "TRANSACTION_DATE", order = 4)
	private Date transactionDate;

	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS", order = 5)
	@NotNull(message = "Transaction Details is required field.")
	private String transactionDetails;

	@Field(value = "WITHDRAWAL_AMOUNT", order = 6)
	private BigDecimal withdrawalAmount;

	@Field(value = "DEPOSIT_AMOUNT", order = 7)
	private BigDecimal depositAmount;

	/**
	 * 1. WITHDRAWAL_AMOUNT / DEPOSIT_AMOUNT should be enter to calculate BALANCE
	 */
	@Field(value = "BALANCE", order = 8)
	@NotNull(message = "Amount is required field.")
	private BigDecimal balance;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;

	/**
	 * 1. Same login user not right to confirm the payment
	 */
	@Field(value = "CONFIRM_PAYMENT", order = 9)
	private Boolean confirmPayment;

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;

	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;

	@Field(value = "PARENT_PAYMENT_ID")
	/* @NotNull(message = "Parent Payment Id is required field.") */ private String parentPaymentId;

	@Embedded
	private AuditData auditData;
}
