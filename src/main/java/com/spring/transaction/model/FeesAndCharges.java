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
	
	@Column(name = "FEES_AND_CHARGES_ID")
	@Id
	private String feesAndChargesId;
	
	@NotNull(message = "Card Details is required field.")
	private String cardDetailsId;
	
	/**
	 * 1. Implement Dynamic multiple in-line grid feature, for enter multiple details of Late Payment
	 * Ex: 	NIL for Total Amount due from Rs.0-Rs.200;
	 * 		Rs. 100 for Total Amount due greater than Rs. 200 & up to Rs. 500;
	 * 		Rs. 400 for Total Amount due greater than Rs. 500 & up to Rs. 1000; 
	 * 
	 * 2. By Clicking on Plus button user can be able to add details of Late Payment charges.
	 */
	@NotNull(message = "Late Payment details is required field.")
	private String latePaymentId;
	
	@NotNull(message = "Cash Advance is required field.")
	private String cashAdvanceId;
	
	/**
	 * 1. Source: SBI -> http://bit.ly/2KmboVh
	 */
	private BigDecimal annualFee;
	private BigDecimal renewalFee;
	private BigDecimal renewalFeeReversedIfAnnualSpendsGreaterThanOrEqual;
	private String renewalFeeReversedDescription;
	private BigDecimal addOnFee;
	private String addOnFeeDescription;
	
	/**
	 * 1. NIL for Total Amount due from Rs.0-Rs.200;
	 * 2. Rs. 100 for Total Amount due greater than Rs. 200 & up to Rs. 500;
	 * 3. Overlimit: 2.5% of overlimit amount subject to a minimum of Rs. 500 
	 */
	private String description;

	private BigDecimal penalty;
	
	/**
	 * 1. Total Amount due greater than Rs. 200 & up to Rs. 500;(><=)
	 * 2. Total Amount due greater than Rs. 25,000;(>)
	 */
	private String condition;
	private BigDecimal dueGreaterThan;
	private BigDecimal dueUpto;
	
	/**
	 * 1. Overlimit: (2.5%) of overlimit amount subject to a minimum of Rs. 500
	 */
	private Float overLimitPercentage;
	
	/**
	 * 1. Overlimit: 2.5% of overlimit amount subject to a minimum of (Rs. 500)
	 * 2. Convert to other currencies if user change it to USD, AUR
	 * 3. Site Reference for Multiple Currencies: https://coinmill.com/AUR_calculator.html
	 */
	private BigDecimal overLimitFee;
	private BigDecimal cardReplacement;
	private BigDecimal emergencyCardReplacementCost;
	private String emergencyCardReplacementCostDescription;
	private BigDecimal cashPaymentFee;
	private BigDecimal chequeFee;
	
	/**
	 * 1. Payments made via cheque upto Rs. 10,000 
	 */
	private BigDecimal chequeFeeCondition;
	private String chequeFeeDescription;
	private BigDecimal statementRetrievalFee;
	private String statementRetrievalDescription;
	
}
