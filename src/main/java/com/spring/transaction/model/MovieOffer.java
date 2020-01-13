package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="MOVIE_OFFER")
public class MovieOffer {
	
	@Id
	@Field(value="MOVIE_OFFER_ID", order = 1)
	private String movieOfferId;
	
	@Field(value="PARTNER_SHIP_ID", order = 2)
	private String partnerShipId;
	
	@Field(value="OFFER_APPLICABLE_FROM_DATE", order = 3)
	private Date offerApplicableFromDate;
	
	@Field(value="OFFER_APPLICABLE_TO_DATE", order = 4)
	private Date offerApplicableToDate;
	
	@Field(value="CASHBACK_ID", order = 5)
	private String cashbackId;
	
	@Field(value="REWARD_CARD_ID", order = 6)
	private String rewardCardId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 7)
	private String customerId;
	
	/**
	 * 1. Same login user not right to confirm the payment
	 * 2. Default value should be null.
	 */
	@Field(value = "CONFIRM_PAYMENT")
	private Boolean confirmPayment;
}
