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
	
	@Id
	@Field(value = "WALLET_PAYMENT_ID", order = 1)									private String walletPaymentId;
	
	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO")													private String referenceNo;
	
	@Field(value = "TRANSACTION_DATE")												private Date transactionDate;
	
	/**
	 * 1. Where the transaction is done.
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS", order = 7) 								private String transactionDetails;
	
	@Field(value="WITHDRAWAL_AMOUNT")												private BigDecimal withdrawalAmount;
	
	@Field(value="DEPOSIT_AMOUNT")													private BigDecimal depositAmount;
	
	@Field(value="BALANCE")															private BigDecimal balance;
	
	
	/**
	 * 1. Check if @Field is not mention how column name created in database
	 */
	@DBRef
	@NotNull(message="Wallet Name is required field.")								private Wallet wallet;
	
	@Field(value = "UPI_APP_ID")													private String upiAppId;
	
	@DBRef
	@NotNull(message="PaymentBy is required field.")								private PaymentBy paymentBy;

	/**
	 * payee name
	 */
	@NotNull(message = "Transfer To is required field.")
	@Field(value="TRANSFER_TO_ID")													private String transferToId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")														private String customerId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT")												private Boolean confirmPayment;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")												private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")												private String paymentStatusId;
	
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")												private String parentPaymentId;
}
