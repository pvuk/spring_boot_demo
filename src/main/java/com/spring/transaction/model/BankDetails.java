package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection="BANK_DETAILS")
public class BankDetails {
	
	@Field("BANK_DETAILS_ID")
	@Id
	private String bankDetailsId;
	
	@Field(value="BANK_ID")
	private String bankId;
	
	@Field(value="BANK_BRANCH_ID")
	private String bankBranchId;
	
	@Field(value="IS_ACTIVE")
	@Type(type="yes_no")
	private Boolean isActive;
	
	/*
	 * if bank account is transferred to other branch then new branch account is in
	 * active state. Transfer from branch isActive false.
	 */
	@Field(value="IS_TRANSFERRED")
	@Type(type="yes_no")
	@Builder.Default
	private Boolean isTransferred = false;
	
	@Field(value="ACCOUNT_CREATED_ON")
	private Date accountCreatedOn;
	
	@Field(value="CHECK_BOOK_ID")
	private String checkBookId;
	
	@Field(value = "TransferOn")
	private Date transferOn;
	
	@Field(value="BALANCE")
	private BigDecimal balance;
	
	@Field(value="DEBIT")
	private BigDecimal debit;
	
	@Field(value="CREDIT")
	private BigDecimal credit;
	
	@Field(value="TRANSFER_DESCRIPTION")
	private String transferDescription;
	
	/**
	 * payee name
	 */
	@Field(value="TRANSFER_TO_ID")
	@NotNull(message = "Transfer To is required field.")
	private String transferToId;
	
	@Field(value="PAYMENT_BY_ID")
	private String paymentById;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
