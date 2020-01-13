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
	
	@BsonId
	@Column(name = "PERSONAL_LOAN_ID")
	private String personalLoanId;
	
	@Column(name = "EMPLOYMENT_TYPE_ID")
	private String employmentTypeId;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor.
	 */
	@Column(name = "COMPANY_EMPLOYED_WITH")
	private String companyEmployedWith;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor.
	 */
	@Column(name = "NET_MONTHLY_INCOME")
	private BigDecimal netMonthlyIncome;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salariedemployee, salarieddoctor, selfemplprofessionaldoctororca, selfemplprofessionalothers.
	 */
	@Column(name = "INCOME_RECEIVED_IN")
	private String incomeReceivedIn;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		salarieddoctor, selfemplprofessionaldoctororca, selfemplprofessionalothers.
	 */
	@Column(name = "YEARS_OF_EXPERIENCE_ID")
	private String yearsOfExperienceId;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplprofessionalothers.
	 */
	@Column(name = "GROSS_ANNUAL_INCOME")
	private BigDecimal grossAnnualIncome;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 */
	@Column(name = "GROSS_ANNUAL_TURN_OVER")
	private BigDecimal grossAnnualTurnover;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 */
	@Column(name = "NET_ANNUAL_PROFITS")
	private BigDecimal netAnnualProfits;
	
	/**
	 * 1. This field should be visible only when employmentTypeId 'code' value equal to 
	 * 		selfemplownbusn.
	 * 2. Refer YEARS_OF_EXPERIENCE_ID for insert / update
	 */
	@Column(name = "YEARS_IN_CURRENT_BUSINESS_ID")
	private String yearsInCurrentBusinessId;
}
