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

/**
 * 
 * @author venkataudaykiranp
 *
 */
@BasePathAwareController
@RequestMapping(value="/cardType/custom")
public class CardTypeController {
	
	@Autowired private CardTypeService cardTypeService;
	
	public @ResponseBody @PostMapping(value = "/save") ResponseEntity<Object> save(@RequestBody CardType cardType) throws Exception {
		return new ResponseEntity<Object>(cardTypeService.save(cardType), HttpStatus.CREATED);
	}
	
	public @ResponseBody @PostMapping(value = "/update") ResponseEntity<Object> update(@RequestBody CardType cardType) throws Exception {
		return new ResponseEntity<Object>(cardTypeService.update(cardType), HttpStatus.OK);
	}
	
	public @ResponseBody @PostMapping(value = "/delete") ResponseEntity<Object> delete(@RequestBody ObjectId cardTypeId) throws Exception {
		return new ResponseEntity<Object>(cardTypeService.delete(cardTypeId), HttpStatus.OK);
	}
	
	public @ResponseBody @GetMapping(value = "/getCardTypeById") ResponseEntity<Object> getCardTypeById(
			@RequestParam(value = "cardTypeId", required = true) ObjectId cardTypeId) throws Exception {
		CardType card = cardTypeService.getCardTypeById(cardTypeId);
		if (card != null && card.getCardTypeId() != null) {
			return new ResponseEntity<Object>(card, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(cardTypeId +" "+ MessageConstants.ID_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
