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
 * @Date Sun 10-Nov-2019 18:44
 */
@Data
@Document(collection = "OFFER_EXPENDITURE")
public class OfferExpenditure {
	
	@Id
	@Field(value = "OFFER_EXPENDITURE_ID")					
	private String offerExpenditureId;
	
	@NotNull(message = "Offer Release is required field.")
	@Field(value = "OFFER_RELEASE_ID")
	private String offerReleaseId;
	
	@Field(value = "PAYMENT_BY_ID")
	private String paymentById;
	
	@NotNull(message = "Spend Amount is required filed.")
	@Field(value = "SPEND")
	private BigDecimal spend;
	
	@Field(value = "REMAINING_SPEND")
	private BigDecimal remainingSpend;
	
	@Field(value = "TOTAL_SPEND")
	private BigDecimal totalSpend;
	
	@Field(value = "SPEND_ON")
	private Date spendOn;
	
	/**
	 * 1. Calculate Current Spend Expenditure is Percentage(5% / 10% /.... / 100%)
	 */
	@Field(value = "SPEND_PERCENTAGE")
	private Double spendPercentage;
	
	/**
	 * 1. Send user notification everyday how much percentage they completed and how much percentage left.
	 * 2. Once offer completed show warning to user, if they tries to doing transaction on offer expenditure.
	 * 3. Once offer expenditure completed send user notification first time / week / month, not more than one month.
	 * 4. Once he / she claim the offer, mark the claim offer from no / yes.
	 */
	@Field(value = "IS_OFFER_EXPENDITURE_COMPLETED")
	private Boolean isOfferExpenditureCompleted;
	
	/**
	 * 1. Don't allow user to change option to YES if isOfferExpenditureCompleted to yes.
	 * 2. After biller release the offer as cashback / coupon / voucher / giftcard, mark this option true.
	 * 3. Once option is marked to true, offerDetailsId should be inserted as per OfferDetails.
	 */
	@Field(value = "OFFER_CLAIMED")
	private Boolean offerClaimed;
	
	@Field(value = "OFFER_DETAILS_ID")
	private String offerDetailsId;
	
	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
	
}
