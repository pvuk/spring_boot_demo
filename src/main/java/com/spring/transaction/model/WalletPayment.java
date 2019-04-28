package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "WALLET_PAYMENT")
public class WalletPayment {
	
	@Id private String walletPaymentId;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON")
	private Date transactionOn;
	
	@NotNull(message="Wallet is required field.")
	@DBRef
	private Wallet wallet;
	
//	@NotNull(message="User is required field.")`
//	@DBRef
//	private String profileId;
	
	@DBRef
	private CardPayment cardPaymentId;
}
