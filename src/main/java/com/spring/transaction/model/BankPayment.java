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

	@Id
	@Field(value = "BANK_PAYMENT_ID", order = 1)
	private String bankPaymentId;

	@NotNull(message = "Bank Can't be empty.")
	@DBRef
	@Field(value = "BANK_CODE", order = 2)
	private Bank bank;

	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS(ONLNPAY_SBI_NEFT_250220201913566740000)
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO", order = 3)
	private String referenceNo;
	
	/**
	 * 1. The date when the entry to an account is considered effective in accounting
	 */
	@Field(value = "VALUE_DATE", order = 4)
	private Date valueDate;
	
	@Field(value = "TRANSACTION_DATE", order = 5)
	private Date transactionDate;

	/**
	 * 1. Where the transaction is done / transaction details.
	 */
	@NotNull(message = "Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS", order = 6)
	private String transactionDetails;
	
	@Field(value="CHECK_BOOK_ID", order = 7)
	private String checkBookId;

	@Field(value = "WITHDRAWAL_AMOUNT", order = 8)
	private BigDecimal withdrawalAmount;

	@Field(value = "DEPOSIT_AMOUNT", order = 9)
	private BigDecimal depositAmount;

	/**
	 * 1. WITHDRAWAL_AMOUNT / DEPOSIT_AMOUNT should be enter to calculate BALANCE
	 */
	@NotNull(message = "Amount is required field.")
	@Field(value = "BALANCE", order = 10)
	private BigDecimal balance;

	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT", order = 11)
	private Boolean confirmPayment;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;

	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;

	@Field(value="PAYMENT_BY_ID", order = 12)
	private String paymentById;
	
	/**
	 * payee name
	 */
	@NotNull(message = "Transfer To is required field.")
	@Field(value="TRANSFER_TO_ID")
	private String transferToId;
	
	/* @NotNull(message = "Parent Payment Id is required field.") */
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;

	@Embedded
	private AuditData auditData;
}
