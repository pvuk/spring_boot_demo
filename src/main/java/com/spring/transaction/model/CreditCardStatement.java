package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_CARD_STATEMENT")
public class CreditCardStatement {
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID", order = 1)
	@Id
	private String creditCardStatementId;
	
	@Field(value = "IS_STATEMENT_CYCLE_CLOSED", order = 2)
	@NotNull(message="Credit Card Statement Cycle Closed is required field.")
	private Boolean isStatementCycleClosed = Boolean.FALSE;
	
	@Field(value = "STATEMENT_FROM", order = 3)
	private Date statementFrom;
	
	@Field(value = "STATEMENT_TO", order = 4)
	private Date statementTo;
	
	@Field(value = "DUE_DATE", order = 5)
	private Date dueDate;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/*
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS")
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
	
	@NotNull(message="Credit card is required field.")
	@DBRef
	private CreditCard creditCardId;
	
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
