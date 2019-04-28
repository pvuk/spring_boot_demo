package com.spring.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

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
	
}
