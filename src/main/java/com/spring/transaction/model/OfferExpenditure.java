package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author Priyanka
 *
 * @Date: Sun 10-Nov-2019 18:44
 */
@Data
@Document(collection = "OFFER_EXPENDITURE")
public class OfferExpenditure {
	
	@Id
	@Field(value = "OFFER_EXPENDITURE_ID")					
	private String offerExpenditureId;
	
	@NotNull(message = "Offer Release is required field.")
	private String offerReleaseId;
	
	private String paymentById;
	
	@NotNull(message = "Spend Amount is required filed.")
	private BigDecimal spend;
	private BigDecimal remainingSpend;
	private BigDecimal totalSpend;
	
	private Date spendOn;
	
	/*
	 * 1. Calculate Current Spend Expenditure is Percentage(5% / 10% /.... / 100%)
	 */
	private Double spendPercentage;
	
	/*
	 * 1. Send user notification everyday how much percentage they completed and how much percentage left.
	 * 2. Once offer completed show warning to user, if they tries to doing transaction on offer expenditure.
	 * 3. Once offer expenditure completed send user notification first time / week / month, not more than one month.
	 * 4. Once he / she claim the offer, mark the claim offer from no / yes.
	 */
	private Boolean isOfferExpenditureCompleted;
	
	/*
	 * 1. Don't allow user to change option to YES if isOfferExpenditureCompleted to yes.
	 * 2. After biller release the offer as cashback / coupon / voucher / giftcard, mark this option true.
	 * 3. Once option is marked to true, offerDetailsId should be inserted as per OfferDetails.
	 */
	private Boolean offerClaimed;
	
	private String offerDetailsId;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
	
}
