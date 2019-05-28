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

@RestController
@RequestMapping(value = "debitCard/service")
public class DebitCardController {

	@Autowired
	private DebitCardService debitCardService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private @ResponseBody DebitCard saveDebitCard(@RequestBody DebitCard debitCard) {
		debitCard = debitCardService.saveDebitCard(debitCard);
		return debitCard;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private @ResponseBody DebitCard updateDebitCard(@RequestBody DebitCard debitCard) {
		debitCard = debitCardService.updateDebitCard(debitCard);
		return debitCard;
	}
	
	@GetMapping(value = "/getByDebitCardId")
	public @ResponseBody ResponseEntity<Object> getByDebitCardId(
			@RequestParam(value = "debitCardId", required = true) ObjectId debitCardId) {
		DebitCard card = debitCardService.getByDebitCardId(debitCardId);
		if (card != null && card.getDebitCardId() != null) {
			return new ResponseEntity<Object>(card, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(debitCardId +" "+ MessageConstants.ID_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
