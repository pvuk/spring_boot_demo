package com.spring.transaction.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.CardType;
import com.spring.transaction.service.CardTypeService;
import com.spring.transaction.validator.MessageConstants;

@BasePathAwareController
@RequestMapping(value="/cardType/custom")
public class CardTypeController {
	
	@Autowired private CardTypeService cardTypeService;
	
	public @ResponseBody @PostMapping(value = "/save") CardType save(@RequestBody CardType cardType) {
		cardType = cardTypeService.save(cardType);
		return cardType;
	}
	
	public @ResponseBody @PostMapping(value = "/update") CardType update(@RequestBody CardType cardType) {
		cardType = cardTypeService.save(cardType);
		return cardType;
	}
	
	public @ResponseBody @PostMapping(value = "/delete") String delete(@RequestBody CardType cardType) {
		return cardTypeService.delete(cardType);
	}
	
	public @ResponseBody @GetMapping(value = "/getCardTypeById") ResponseEntity<Object> getCardTypeById(
			@RequestParam(value = "cardTypeId", required = true) ObjectId cardTypeId) {
		CardType card = cardTypeService.getCardTypeById(cardTypeId);
		if (card != null && card.getCardTypeId() != null) {
			return new ResponseEntity<Object>(card, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(cardTypeId +" "+ MessageConstants.ID_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
