package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="FEE_WAIVER")
public class FeeWaiver {
	
	@Field(value="FEE_WAIVER_ID")
	@Id
	private String feeWaiverId;
	
	@Field(value="PAYMENT_HISTORY_ID")
	private String paymentHistoryId;
	
	@Field(value="CARD_DETAILS_ID")
	@NotNull(message = "Card is required field.")
	private String cardDetailsId;
	
	@Field(value = "MILESTONE_ACHIEVEMENT_ID")
	private Long mileStoneAchievementId;
	
	@Field(value = "TOTAL_SPENDS")
	private BigDecimal totalSpends;
	
	@Field(value = "ANNUAL_FEE_WAIVER_OFF_ON_TOTAL_SPENDS_OF")
	private BigDecimal annualFeeWaiverOffOnTotalSpendsOf;
	
	@Field(value="ANNUAL_FEE")
	private BigDecimal annualFee;
	
	@Field(value = "ANNUAL_FEE_TAX_OF_GST_OR_IGST")
	private BigDecimal annualFeeTaxOfGSTOrIGST;
	
	@Field("ANNUAL_FEE_DATE")
	private Date annualFeeDate;
	
	@Field(value = "ANNUAL_FEE_WAIVER_CONDITION")
	private String annualFeeWaiverCondition;
	
	@Field(value = "REMAINING_SPENDS_LEFT_FOR_ANNUAL_FEE_WAIVER")
	private BigDecimal remainingSpendsLeftForAnnualFeeWaiver;
	
	@Field(value = "ANNUAL_FEE_WAIVER_IF_SPENDS_BEFORE_ON")
	private Date annualFeeWaiverIfSpendsBeforeOn;
	
	@Field(value="ANNUAL_FEE_WAIVER_AMOUNT")
	private BigDecimal annualFeeWaiverAmount;
	
	@Field(value = "ANNUAL_FEE_WAIVER_TAX_OF_GST_OR_IGST")
	private BigDecimal annualFeeWaiverTaxOfGSTOrIGST;
	
	@Field("ANNUAL_FEE_WAIVER_ON")
	private Date annualFeeWaiverOn;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;

	@Transient
	private Date mileStoneAchievedIfSpendsBeforeOn;
}
