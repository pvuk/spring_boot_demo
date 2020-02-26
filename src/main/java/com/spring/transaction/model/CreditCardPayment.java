package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CREDIT_CARD_PAYMENT")
public class CreditCardPayment {

	@Id
	@Field(value="CREDIT_CARD_PAYMENT_ID", order = 1)
	private String creditCardPaymentId;
	
	@NotNull(message="Credit Card is required field.")
	@Field(value="CREDIT_CARD_ID", order = 2)
	private String creditCardId;
	
	/**
	 * 1. Following columns are one group 
	 * CONFIRM_WITH_CREDIT_CARD_STATEMENT_TRANSACTION_ID, 
	 * CREDIT_CARD_STATEMENT_ID, 
	 * CREDIT_CARD_STATEMENT_TRANSACTION_ID, 
	 * CREDIT_CARD_STATEMENT_DATE.
	 * 
	 * 2. If CONFIRM_WITH_CREDIT_CARD_STATEMENT_TRANSACTION_ID updated remaining columns also need to be updated.
	 * 
	 * 3. Once Credit Card Statement is generated match CREDIT_CARD_PAYMENT_ID transaction with CONFIRM_WITH_CREDIT_CARD_STATEMENT_TRANSACTION_ID.
	 */
	@Field(value = "CONFIRM_WITH_CREDIT_CARD_STATEMENT_TRANSACTION_ID")
	private Boolean confirmWithCreditCardStatementTransactionId;
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID")
	private String creditCardStatementId;
	
	@Field(value = "CREDIT_CARD_STATEMENT_TRANSACTION_ID")
	private String creditCardStatementTransactionId;
	
	/**
	 * 1. CREDIT_CARD_STATEMENT_DATE should be display in DropDown as FromDate To ToDate [03-Jan-2020 To 02-Feb-2020](Reference: CREDIT_CARD_STATEMENT -> STATEMENT_PERIOD).
	 */
	@Field(value = "CREDIT_CARD_STATEMENT_DATE")
	private String creditCardStatementDate;
	
	@NotNull(message="Amount is required field.")
	@Field(value="AMOUNT", order = 3)
	private BigDecimal amount;
	
	@Field(value = "TRANSACTION_ON", order = 4)
	private Date transactionOn;

	/**
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS(CC_SBI_SIMCLK_250220201915285920000)
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	@Field(value = "REFERENCE_NO")
	private String referenceNo;
	
	/**
	 * 1. To show creditcardcreditpay / debitcardcreditpay(Others Amount) / debitcardpay / featurepay / latepay / minimumpay / netbankingpay / overpay / rewardpointspay / upipay / walletpay / partialpay / fullpay
	 * open popup
	 */
	@NotNull(message="Payment By is required field.")
	@Field(value = "PAYMENT_BY_ID")
	private List<String> paymentById;
	
	/**
	 * 1. If user selects code "overpay", select default option "fullpay" from PAY_TYPE_CODE.
	 */
	@NotNull(message="Pay Type is required field.")
	@Field(value = "PAY_TYPE_ID")
	private String payTypeId;
	
	/**
	 * 1. Brief Description Transaction related details.
	 */
	@NotNull(message="Transaction Details is required field.")
	@Field(value = "TRANSACTION_DETAILS")
	private String transactionDetails;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 5)
	private String customerId;
	
	/**
	 * 1. Same login user not authorize to CONFIRM_PAYMENT.
	 * 2. Default value should be null.
	 * 3. CONFIRM_PAYMENT in the sense NetBanking / UPI / CASH / DebitCard / Wallet / Cheque. 
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
	
	@Field(value = "CONFIRM_CREDIT_CARD_CREDIT_AMOUNT")
	private Boolean confirmCreditCardCreditAmount;
	
	/**
	 * 1. Accept only credit, debit options from put-payment_type_code.json file.
	 */
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")
	private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")
	private String paymentStatusId;
	
	/**
	 * 1. CREDIT_CARD_STATEMENT_ID is PARENT_PAYMENT_ID
	 */
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")
	private String parentPaymentId;
	
}
