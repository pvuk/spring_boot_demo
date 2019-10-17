package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * <ol>
 * 	<li>
 * 		<h2>This Document properties Supporting feature on CC:</h2>
 * 		<ol>
 * 			<li>Bajaj Finserv RBL Bank</li>
 * 			<li>RBL Bank</li>
 * 		</ol>
 * </li>
 * 		
 * </ol>
 *
 */
@Data
@Document(collection = "CREDIT_CARD_STATEMENT_TRANSACTION")
public class CreditCardStatementTransaction {
	
	@Id
	private String creditCardStatementTransactionId;
	
	@Column(name = "CREDIT_CARD_STATEMENT_ID")
	@NotNull(message = "Credit Card Statement is required field.")
	private String creditCardStatementId;
	
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	private Date transactionOn;
	/*
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DESCRIPTION")
	@NotNull(message="Transaction Details / Description is required field.")
	private String transactionDescription;
	
	/*
	 * Supporting feature on
	 * 1. Bajaj Finserv RBL Bank
	 */
	private BigDecimal foreignCurrenncyAmount;
	/*
	 * 1. Amount in Rs(INR)
	 */
	private BigDecimal amount;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
