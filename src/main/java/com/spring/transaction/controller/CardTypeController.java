package com.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.CardType;
import com.spring.transaction.service.CardTypeService;

@BasePathAwareController
@RequestMapping(value="/cardType/service")
public class CardTypeController {
	
	@Autowired private CardTypeService cardTypeService;
	
	@PostMapping(value = "/save")
	public @ResponseBody CardType save(@RequestBody CardType cardType) {
		cardType = cardTypeService.save(cardType);
		return cardType;
	}
	
	@PostMapping(value = "/update")
	public @ResponseBody CardType update(@RequestBody CardType cardType) {
		cardType = cardTypeService.save(cardType);
		return cardType;
	}
	
	@PostMapping(value = "/delete")
	public @ResponseBody String delete(@RequestBody CardType cardType) {
		return cardTypeService.delete(cardType);
	}
	
	@GetMapping(value = "/getCardTypeById")
	public @ResponseBody CardType getCardTypeById(
			@RequestParam(value = "cardTypeId", required = true) String cardTypeId) {
		return cardTypeService.getCardTypeById(cardTypeId);
	}
}
