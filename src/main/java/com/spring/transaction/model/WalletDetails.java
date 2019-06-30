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
@Builder
@Document(collection = "WALLET_DETAILS")
public class WalletDetails {
	
	@Field(value = "WALLET_DETAILS_ID")
	@Id
	private String walletDetailsId;
	
	@NotNull(message = "Wallet is required field.")
	private String walletId;
	
	@Field(value="IS_ACTIVE")
	@Type(type="yes_no")
	private Boolean isActive;
	
	/*
	 * if account is transferred to other number then new account is in
	 * active state. Transfer from number isActive false.
	 */
	@Field(value="IS_TRANSFERRED")
	@Type(type="yes_no")
	@Builder.Default
	private Boolean isTransferred = false;
	
	@Field(value="ACCOUNT_CREATED_ON")
	private Date accountCreatedOn;
	
	@Field(value = "TransferOn")
	private Date transferOn;
	
	@Field(value="BALANCE")
	private BigDecimal balance;
	
	@Field(value="DEBIT")
	private BigDecimal debit;
	
	@Field(value="CREDIT")
	private BigDecimal credit;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
