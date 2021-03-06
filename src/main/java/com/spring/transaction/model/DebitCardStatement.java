package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "DEBIT_CARD_STATEMENT")
public class DebitCardStatement {

	@Id
	@Field(value = "DEBIT_CARD_STATEMENT_ID", order = 1)
	private String debitCardStatementId;
	
	@Type(type="yes_no")
	@Field(value = "IS_STATEMENT_CYCLE_CLOSED", order = 2)
	private Boolean isStatementCycleClosed = Boolean.FALSE;
	
/**=============================Start of section - Savings Account / Current Account AccountSummary =============================**/
	
	/**
	 * As per ICICI monthly Statement
	 * 
	 * 1. REFERENCE_NO format should be SOURCETYPE_BANK_SOURCENAME_ddMMYYYYHHmmssSSSSSSS
	 * 2. Following are short code "ONLNPAY/CSH/DC/CC/WLT/CHQ/NTBNG/RC" check these brief details in put-legend_code.json file.
	 */
	private String statementReferenceNo;
	
	@NotNull(message = "Page Reference is required field.")
	@Field(value = "PAGE_REFERENCE")
	private String pageReference;
	
	@Field(value = "WEB_SITE_LINK")
	private String webSiteLink;
	
	/**
	 * 1. save as following format 1860 120 7777
	 */
	@Field(value = "CONTACT_NUMBER")
	private String contactNumber;
	
	
	/**** Start of section - CreditCard AccountSummary ****/
	@Column(name = "FULL_NAME") 							private String fullName;
	@Column(name = "ADDRESS") 								private String address;
	@Column(name ="STATEMENT_SUMMARY")						private String statementSummary;
	@Column(name = "STATEMENT_SUMMARY_DATE")				private Date statementSummaryDate;
	
	private Long currencyId;
	
	/**
	 * 1. As Per ICICI monthly statement. Current Account, Savings Account
	 */
	private String bankAccountTypeId;
	
	private BigDecimal accountBalance;
	private BigDecimal fixedDeposits_linked_balance;
	private BigDecimal totalBalance;
	private String nomination;
	
	private String statementTransactionDescription;
	
	/**
	 * 1. Statement Period should be saved as August 01, 2019 - August 31, 2019
	 */
	@Column(name = "STATEMENT_PERIOD") 						private String statementPeriod; 
	
/**============================= End of section - Savings Account / Current Account AccountSummary =============================**/
	
	
/**============================= Start of section - Savings Account / Current Account RewardPoints Summary =============================**/
	
	private String savingsAccountNumber;
	
	/**
	 * 1.Account Number should be displayed as XXXXXXXXXXXX1905
	 */
	private String linkedPaybackNumber;
	private String rewardCardId;
	
	/**
	 * 1. Points earned for the month of
	 */
	private String pointsEarnedDescription;
	
	/**
	 * 1. Date display format July, 2019
	 */
	private Date pointsEarnedMonth;
	
	private Long mySavingsReward;
	
	private Long debitCard;
	
	@NotNull(message="Debit card is required field.")
	private String debitCardId;
	
	@Column(name = "POINT_BALANCE") private BigDecimal pointBalance;
	
	private String pointsSummaryComment;
	
/**============================= End of section - CreditCard RewardPoints Summary =============================**/
	
	private String bankBranchId;
	
	private List<String> legendIds;
	
	private String rewardPointsDetailsId;
	
	/**
	 * 1. check how this field position is placed in MongoDB., because only few columns order are mentioned.
	 */
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 6)											private String customerId;

	@Transient 																		private Set<DebitCardStatementTransaction> dcStatementTransactionSet;
}
