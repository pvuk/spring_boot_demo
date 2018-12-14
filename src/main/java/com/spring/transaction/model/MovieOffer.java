package com.spring.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="MOVIE_OFFER")
public class MovieOffer {
	
	private Long movieOfferId;
	private String movieOfferAtParterns;
	private Long offerApplicableDayFromId;	
	private Long offerApplicableDayToId;
	private Long cashbackId;
	private Long rewardCardId;
	
}
