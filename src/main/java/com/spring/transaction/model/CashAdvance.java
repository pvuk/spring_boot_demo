package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CASH_ADVANCE")
public class CashAdvance {

	@Id
	@Column(name = "CASH_ADVANCE_ID")
	private String cashAdvanceId;
	
	@NotNull(message = "Fess And Charges is required field.")
	private String feesAndChargesId;
	
	private String cashAdvanceLimitDescription;
	private Float cashAdvanceLimitPercentage;
	private BigDecimal cashAdvancePerDayLimit;
	
	private Date cashAdvanceOn;
	
	private String financeChargesDescription;
	private BigDecimal financeCharges;
	private Date financeChargesFrom;
	
	private String withdrawalDescription;
	private Float withdrawalPercentage;
	private BigDecimal withdrawalFee;
	
	private String internationalATMSDescriptoin;
	private Float internationalATMSPercentage;
	private BigDecimal internationalATMSFee;
}
