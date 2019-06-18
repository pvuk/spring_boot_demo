package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.MovieOffer;
import com.spring.transaction.repository.MovieOfferRepository;
import com.spring.transaction.service.MovieOfferService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
@Slf4j
public class MovieOfferServiceImpl implements MovieOfferService {

	@Autowired private MovieOfferRepository movieOfferRepo;
	
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
	public String deleteById(ObjectId movieOfferId) throws Exception {
		try {
			movieOfferRepo.deleteById(movieOfferId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

	
}
