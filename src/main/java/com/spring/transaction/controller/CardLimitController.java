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
import com.spring.transaction.model.CardLimit;
import com.spring.transaction.service.CardLimitService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value = "/creditLimit/custom/")
public class CardLimitController {

	@Autowired
	private CardLimitService cardLimitService;

	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required = true) CardLimit cardLimit)
			throws Exception {
		String message = cardLimitService.save(cardLimit);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}

	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required = true) List<CardLimit> cardLimits)
			throws Exception {
		List<CardLimit> list = cardLimitService.saveAll(cardLimits);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody CardLimit cardLimit) throws Exception {
		String message = cardLimitService.update(cardLimit);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(
			@RequestParam(required = true, value = "cardLimitId") ObjectId cardLimitId) throws Exception {
		String message = cardLimitService.deleteById(cardLimitId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getCreditLimitById")
	public @ResponseBody ResponseEntity<Object> getCreditLimitById(
			@RequestParam(required = true, value = "cardLimitId") ObjectId cardLimitId) throws Exception {
		CardLimit CreditLimit = cardLimitService.getCreditLimitById(cardLimitId);
		return new ResponseEntity<Object>(CreditLimit, HttpStatus.OK);
	}
}
