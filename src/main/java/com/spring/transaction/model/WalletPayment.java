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
	
	/**
	 * 1. Check if @Field is not mention how column name created in database
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
	
	@Field(value = "UPI_APP_ID")
	private String upiAppId;
	
	@NotNull(message="PaymentBy is required field.")
	@DBRef
	private PaymentBy paymentBy;

	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_DETAILS")
	@NotNull(message="Transaction Details is required field.")
	private String transactionDetails;
	
	@Field(value="CUSTOMER_ID", order = 4)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
