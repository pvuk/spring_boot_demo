package com.spring.transaction.model;

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
	
	@Field(value = "WALLET_STATUS_ID")
	private String walletStatusId;
	
	@Field(value = "WALLET_CARD_ID")
	private String walletCardId;
	
	/**
	 * 1. If account is transferred to other number then new account is in
	 * active state. Transfer from number isActive false.
	 */
	@Field(value="IS_TRANSFERRED")
	@Type(type="yes_no")
	@Builder.Default
	private Boolean isTransferred = false;
	
	@Field(value="ACCOUNT_CREATED_ON")
	private Date accountCreatedOn;
	
	@Field(value="CARD_LIMIT_ID")
	private String cardLimitId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
