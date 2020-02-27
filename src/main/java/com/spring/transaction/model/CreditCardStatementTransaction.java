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
	@Field(value = "CREDIT_CARD_STATEMENT_TRANSACTION_ID")
	private String creditCardStatementTransactionId;
	
	@NotNull(message = "Credit Card Statement is required field.")
	@Field(value = "CREDIT_CARD_STATEMENT_ID")
	private String creditCardStatementId;
	
	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	@Field(value = "TRANSACTION_ON")
	private Date transactionOn;
	
	/**
	 * 1. Brief Description about Transaction related details
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	/**
	 * <ul>
	 * 	<li>Supporting feature on
	 * 		<ol>1. Bajaj Finserv RBL Bank</ol>
	 * 	</li>
	 * </ul>
	 */
	@Field(value = "FOREIGN_CURRENNCY_AMOUNT")
	private BigDecimal foreignCurrenncyAmount;
	
	/**
	 * 1. Amount in Rs(INR)
	 */
	@Field(value = "AMOUNT")
	private BigDecimal amount;
	
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	@NotNull(message="Customer is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
}
