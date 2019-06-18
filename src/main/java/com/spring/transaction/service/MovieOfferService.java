package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.MovieOffer;

public interface MovieOfferService {

	MovieOffer getMovieOfferById(ObjectId movieOfferId) throws Exception;
	
	String save(MovieOffer movieOffer) throws Exception;
	
	List<MovieOffer> saveAll(List<MovieOffer> movieOffers) throws Exception;
	
	String update(MovieOffer movieOffer) throws Exception;
	
	String deleteById(ObjectId movieOfferId) throws Exception;
}
