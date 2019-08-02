package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.persistence.Column;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * 
 * <p> Source for this table reference visit <a href="https://personal-loan.gosahi.com/employment-details">personal-loan.gosahi.com</a></p>
 *
 */
@Data
@Document(collection = "PERSONAL_LOAN")
public class PersonalLoan {
	
	@Column(name = "PERSONAL_LOAN_ID")
	@BsonId
	private String personalLoanId;
	
	private String employmentTypeId;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor.
	 */
	private String companyEmployedWith;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor.
	 */
	private BigDecimal netMonthlyIncome;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor, selfemplprofessionaldoctororca, selfemplprofessionalothers.
	 */
	private String incomeReceivedIn;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salarieddoctor, selfemplprofessionaldoctororca, selfemplprofessionalothers.
	 */
	private String yearsInCurrentProfessionId;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplprofessionalothers.
	 */
	private BigDecimal grossAnnualIncome;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 */
	private BigDecimal grossAnnualTurnover;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 */
	private BigDecimal netAnnualProfits;
	
	/*
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 */
	private String yearsInCurrentBusinessId;
}
