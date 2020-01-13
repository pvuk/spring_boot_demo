package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="FEES_AND_CHARGES_CODE")
public class FeesAndCharges {
	
	@Id
	@Column(name = "FEES_AND_CHARGES_ID")													private String feesAndChargesId;
	
	@NotNull(message = "Card Details is required field.")
	@Column(name = "CARD_DETAILS_ID")														private String cardDetailsId;
	
	/**
	 * 1. Implement Dynamic multiple in-line grid feature, for enter multiple details of Late Payment
	 * Ex: 	NIL for Total Amount due from Rs.0-Rs.200;
	 * 		Rs. 100 for Total Amount due greater than Rs. 200 & up to Rs. 500;
	 * 		Rs. 400 for Total Amount due greater than Rs. 500 & up to Rs. 1000; 
	 * 
	 * 2. By Clicking on Plus button user can be able to add details of Late Payment charges.
	 */
	@NotNull(message = "Late Payment details is required field.")
	@Column(name = "LATE_PAYMENT_ID")														private String latePaymentId;
	
	@NotNull(message = "Cash Advance is required field.")
	@Column(name = "CASH_ADVANCE_ID")														private String cashAdvanceId;
	
	/**
	 * 1. Source: SBI -> http://bit.ly/2KmboVh
	 */
	@Column(name = "ANNUAL_FEE")															private BigDecimal annualFee;
	@Column(name = "RENEWAL_FEE")															private BigDecimal renewalFee;
	@Column(name = "RENEWAL_FEE_REVERSED_IF_ANNUAL_SPENDS_GREATER_THAN_OR_EQUAL")			private BigDecimal renewalFeeReversedIfAnnualSpendsGreaterThanOrEqual;
	@Column(name = "RENEWAL_FEE_REVERSED_DESCRIPTION")										private String renewalFeeReversedDescription;
	@Column(name = "ADD_ON_FEE")															private BigDecimal addOnFee;
	@Column(name = "ADD_ON_FEE_DESCRIPTION")												private String addOnFeeDescription;
	
	/**
	 * 1. NIL for Total Amount due from Rs.0-Rs.200;
	 * 2. Rs. 100 for Total Amount due greater than Rs. 200 & up to Rs. 500;
	 * 3. Overlimit: 2.5% of overlimit amount subject to a minimum of Rs. 500 
	 */
	@Column(name = "DESCRIPTION")															private String description;

	@Column(name = "PENALTY")																private BigDecimal penalty;
	
	/**
	 * 1. Total Amount due greater than Rs. 200 & up to Rs. 500;(><=)
	 * 2. Total Amount due greater than Rs. 25,000;(>)
	 */
	@Column(name = "CONDITION")																private String condition;
	@Column(name = "DUE_GREATER_THAN")														private BigDecimal dueGreaterThan;
	@Column(name = "DUE_UP_TO")																private BigDecimal dueUpto;
	
	/**
	 * 1. Overlimit: (2.5%) of overlimit amount subject to a minimum of Rs. 500
	 */
	@Column(name = "OVER_LIMIT_PERCENTAGE")													private Float overLimitPercentage;
	
	/**
	 * 1. Overlimit: 2.5% of overlimit amount subject to a minimum of (Rs. 500)
	 * 2. Convert to other currencies if user change it to USD, AUR
	 * 3. Site Reference for Multiple Currencies: https://coinmill.com/AUR_calculator.html
	 */
	@Column(name = "OVER_LIMIT_FEE")														private BigDecimal overLimitFee;
	@Column(name = "CARD_REPLACEMENT")														private BigDecimal cardReplacement;
	@Column(name = "EMERGENCY_CARD_REPLACEMENT_COST")										private BigDecimal emergencyCardReplacementCost;
	@Column(name = "EMERGENCY_CARD_REPLACEMENT_COST_DESCRIPTION")							private String emergencyCardReplacementCostDescription;
	@Column(name = "CASH_PAYMENT_FEE")														private BigDecimal cashPaymentFee;
	@Column(name = "CHEQUE_FEE")															private BigDecimal chequeFee;
	
	/**
	 * 1. Payments made via cheque upto Rs. 10,000 
	 */
	@Column(name = "CHEQUE_FEE_CONDITION")													private BigDecimal chequeFeeCondition;
	@Column(name = "CHEQUE_FEE_DESCRIPTION")												private String chequeFeeDescription;
	@Column(name = "STATEMENT_RETRIEVAL_FEE")												private BigDecimal statementRetrievalFee;
	@Column(name = "STATEMENT_RETRIEVAL_DESCRIPTION")										private String statementRetrievalDescription;
	
}
