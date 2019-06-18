package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.MovieOffer;
import com.spring.transaction.service.MovieOfferService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/movieOffer/custom/")
public class MovieOfferController {

	@Autowired private MovieOfferService movieOfferService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) MovieOffer movieOffer) throws Exception {
		String message = movieOfferService.save(movieOffer);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<MovieOffer> movieOffers) throws Exception {
		List<MovieOffer> list = movieOfferService.saveAll(movieOffers);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody MovieOffer movieOffer) throws Exception {
		String message = movieOfferService.update(movieOffer);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "movieOfferId") ObjectId movieOfferId) throws Exception {
		String message = movieOfferService.deleteById(movieOfferId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getMovieOfferById")
	public @ResponseBody ResponseEntity<Object> getMovieOfferById(@RequestParam(required = true, value = "movieOfferId") ObjectId movieOfferId) throws Exception {
		MovieOffer MovieOffer = movieOfferService.getMovieOfferById(movieOfferId);
		return new ResponseEntity<Object>(MovieOffer, HttpStatus.OK);
	}
}
