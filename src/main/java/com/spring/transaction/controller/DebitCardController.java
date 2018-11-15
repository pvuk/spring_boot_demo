package com.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.service.DebitCardService;

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
}
