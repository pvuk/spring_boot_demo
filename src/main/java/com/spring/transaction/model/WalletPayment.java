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
	
	@Field(value = "WALLET_PAYMENT_ID", order = 1)
	@Id private String walletPaymentId;
	
	/*
	 * check if @Field is not mention how column name created in database
	 */
	@NotNull(message="Wallet is required field.")
	private String walletDetailsId;
	
	@Field(value="AMOUNT", order = 2)
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 3)
	private Date transactionOn;
	
	@NotNull(message="Wallet is required field.")
	@DBRef
	private Wallet wallet;
	
	@NotNull(message="PaymentBy is required field.")
	@DBRef
	private PaymentBy paymentBy;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
}
