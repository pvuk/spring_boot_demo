package com.spring.transaction.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.service.DebitCardService;
import com.spring.transaction.validator.MessageConstants;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value = "debitCard/custom")
public class DebitCardController {

	@Autowired
	private DebitCardService debitCardService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<Object> save(@RequestBody DebitCard debitCard) throws Exception {
		return new ResponseEntity<Object>(debitCardService.save(debitCard), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<Object> update(@RequestBody DebitCard debitCard) throws Exception {
		return new ResponseEntity<Object>(debitCardService.update(debitCard), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByDebitCardId")
	public @ResponseBody ResponseEntity<Object> getByDebitCardId(
			@RequestParam(value = "debitCardId", required = true) ObjectId debitCardId) throws Exception {
		DebitCard card = debitCardService.getDebitCardById(debitCardId);
		if (card != null && card.getDebitCardId() != null) {
			return new ResponseEntity<Object>(card, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(debitCardId +" "+ MessageConstants.ID_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
