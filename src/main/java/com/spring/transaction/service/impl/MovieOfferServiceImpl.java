package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.MovieOffer;
import com.spring.transaction.service.MovieOfferService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class MovieOfferServiceImpl implements MovieOfferService {

	@Override
	public MovieOffer getMovieOfferById(ObjectId movieOfferId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(MovieOffer movieOffer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieOffer> saveAll(List<MovieOffer> movieOffers) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(MovieOffer movieOffer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieOfferById(ObjectId movieOfferId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
