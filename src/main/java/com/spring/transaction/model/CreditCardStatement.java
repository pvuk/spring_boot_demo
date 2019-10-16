package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
 * 			<li>RBL Bank</li>
 * 			<ol>
 * 				<li>Movie Block Buster</li>
 * 				<li>Bajaj Finserv RBL Bank</li>
 * 			</ol>
 * 			<li>Citi Bank</li>
 * 			<ol>
 * 				<li>Indian Oil</li>
 * 			</ol>
 * 		</ol>
 * </li>
 * 		
 * </ol>
 *
 */
@Data
@Document(collection = "CREDIT_CARD_STATEMENT")
public class CreditCardStatement {
	
	@Field(value = "CREDIT_CARD_STATEMENT_ID", order = 1)
	@Id
	private String creditCardStatementId;
	
	@Field(value = "IS_STATEMENT_CYCLE_CLOSED", order = 2)
	@NotNull(message="Credit Card Statement Cycle Closed is required field.")
	private Boolean isStatementCycleClosed = Boolean.FALSE;
	
	/*Start of section - CreditCard AccountSummary*/
	@Column(name = "FULL_NAME") 			private String fullName;
	@Column(name = "CARD_NUMBER") 			private String cardNumber;
	@Column(name = "STATEMENT_PERIOD") 		private String statementPeriod;
	@Column(name = "STATEMENT_DATE") 		private Date statementDate;
	@Column(name = "MINIMUM_PAYMENT_DUE") 	private BigDecimal minimumPaymentDue;
	@Column(name = "PAYMENT_DUE_DATE") 		private Date paymentDueDate;

	/*
	 * OPENING_BALANCE column also referred as Previous_Balance
	 */
	@Column(name = "OPENING_BALANCE") 			private BigDecimal openingBalance;
	/*
	 * PAYMENTS_AND_CREDITS column also referred as Last_Payments_Received
	 */
	@Column(name = "PAYMENTS_AND_CREDITS") 		private BigDecimal paymentsAndCredits;
	/*
	 * NEW_PURCHASES column also referred as CurrentPurchases_AND_OtherCharges
	 */
	@Column(name = "NEW_PURCHASES") 			private BigDecimal newPurchases;
	@Column(name = "MONTHLY_EMI_DEBITS") 		private BigDecimal monthlyEMIDebits;
	@Column(name = "GOODS_AND_SERVICES_TAX") 	private BigDecimal goodsAndServicesTax;
	@Column(name = "TOTAL_AMOUNT_DUE") 			private BigDecimal totalAmountDue;
	
	@Column(name = "UNBILLED_PRINCIPAL") 		private BigDecimal unbilledPrincipal;
	@Column(name = "TOTAL_CREDIT_LIMIT") 		private BigDecimal totalCreditLimit;
	@Column(name = "AVAILABLE_CREDIT_LIMIT") 	private BigDecimal availableCreditLimit;
	@Column(name = "CURRENT_CASH_ADVANCE")		private BigDecimal currentCashAdvance;
	@Column(name = "AVAILABLE_CASH_LIMIT") 		private BigDecimal availableCashLimit;
	/*End of section - CreditCard AccountSummary*/
	
	
	/*Start of section - CreditCard RewardPoints Summary*/
	@Column(name = "OPENING_REWARD_POINTS") private BigDecimal openingRewardPoints;
	/*
	 * EARNED column also referred as Turbo_Points_Earned
	 */
	@Column(name = "EARNED") 				private BigDecimal earned;
	@Column(name = "ADJUSTED") 				private BigDecimal adjusted;
	@Column(name = "REDEEMED") 				private BigDecimal redeemed;
	@Column(name = "CLOSING_REWARD_POINTS") private BigDecimal closingRewardPoints;
	@Column(name = "POINTS_TO_EXPIRE") 		private BigDecimal pointsToExpire;
	@Column(name = "EXPIRE_ON") 			private Date expireOn;
	/*End of section - CreditCard RewardPoints Summary*/
	
	private String rewardPointsId;
	
	private Set<CreditCardStatementTransaction> ccStatementTransactionSet;
	
	@NotNull(message="Credit card is required field.")
	@DBRef
	private CreditCard creditCardId;
	
	private String creditCardModeOfPaymentId;
	
	/*
	 * check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@Field(value="CUSTOMER_ID", order = 6)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
