package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "STATEMENT_CREDIT_CARD")
public class StatementCreditCard {
	
	@Id
	private String statementCreditCardId;
	
	@NotNull(message="Credit Card Statement Cycle Closed is required field.")
	private Boolean isStatementCycleClosed = Boolean.FALSE;
	
	private Date statementFrom;
	private Date statementTo;
	private Date dueDate;
	
	@NotNull(message="Credit card is required field.")
	@DBRef
	private CreditCard creditCardId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
