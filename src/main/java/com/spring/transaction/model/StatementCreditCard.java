package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "STATEMENT_CREDIT_CARD")
public class StatementCreditCard {
	
	@BsonId
	private String statementCreditCardId;
	
	@NotNull(message="Credit Card Statement Cycle Closed is required field.")
	private Boolean isStatementCycleClosed = Boolean.FALSE;
	
	private Date statementFrom;
	private Date statementTo;
	private Date dueDate;
}
