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
	
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	@Field(value = "TRANSACTION_DATE")
	private Date transactionDate;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@Field(value = "TRANSACTION_REMARKS")
	@NotNull(message="Transaction Remarks is required field.")
	private String transactionRemarks;
	
	@Field(value="WITHDRAWAL_AMOUNT")
	private BigDecimal withdrawalAmount;
	
	@Field(value="DEPOSIT_AMOUNT")
	private BigDecimal depositAmount;
	
	@Field(value="BALANCE")
	private BigDecimal balance;
	
	
	/**
	 * 1. Check if @Field is not mention how column name created in database
	 */
	@NotNull(message="Wallet Name is required field.")
	@DBRef
	private Wallet wallet;
	
	@Field(value = "UPI_APP_ID")
	private String upiAppId;
	
	@NotNull(message="PaymentBy is required field.")
	@DBRef
	private PaymentBy paymentBy;

	/**
	 * payee name
	 */
	@Field(value="TRANSFER_TO_ID")
	@NotNull(message = "Transfer To is required field.")
	private String transferToId;
	
	@Field(value="CUSTOMER_ID")
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
