package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="MOVIE_OFFER")
public class MovieOffer {
	
	private String movieOfferId;
	private String movieOfferAtParterns;
	private Long offerApplicableDayFromId;	
	private Long offerApplicableDayToId;
	private String cashbackId;
	private String rewardCardId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
