package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "OFFER_RELEASE")
public class OfferRelease {
	
	@Id
	@Field(value = "OFFER_RELEASE_ID")					private String offerReleaseId;
	
	@Field(value = "MIN_SPEND")							private BigDecimal minSpend;
	@Field(value = "MAX_SPEND")							private BigDecimal maxSpend;
	@Field(value = "Cash_BACK_PERCENTAGE")				private Double cashBackPercentage;
	@Field(value = "CASH_BACK_UPTO")					private BigDecimal cashBackUpTo;
	@Field(value = "MAX_CASHBACK")						private BigDecimal maxCashBack;
	@Field(value = "OFFER_VALID_FROM")					private Date offerValidFrom;
	@Field(value = "OFFER_VALID_TO")					private Date offerValidTo;
	@Field(value = "PARTICIPATED_ON")					private Date participatedOn;
	
	@Field(value = "VALID_ONCE_PER_CARD")				private Boolean validOncePerCard;
	@Field(value = "VALID_MULTIPLE_TIMES_PER_CARD")		private Boolean validMultipleTimesPerCard;
	
	@Field(value = "OFFER_TYPE_ID")						private String offerTypeId;
	
	@Field(value = "COMMENT")							private String comment;
	
	@Field(value = "OFFER_STATUS_ID")					private String offerStatusId;
	
	@Field(value = "SPEND_STATUS_ID")					private String spendStatusId;
													
	@Field(value = "OFFER_DETAILS_ID")					private String offerDetailsId;
	
	@Field(value = "OFFER_VISIBLE_TO_OTHERS")			private Boolean offerVisibleToOthers;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
