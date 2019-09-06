package com.spring.transaction.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.CreditCard;
import com.spring.transaction.service.CreditCardService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/creditCard/custom")
public class CreditCardController {

	@Autowired private CreditCardService creditCardService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) CreditCard creditCard) throws Exception {
		String message = creditCardService.save(creditCard);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	/*
	 * https://httpstatuses.com/304
	 */
//	@TrackTime
//	@NoLogging
	@PostMapping(path = "/saveAll")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<CreditCard>> saveAll(HttpServletRequest request, @RequestBody(required=true) List<CreditCard> creditCards) throws Exception {
		List<CreditCard> list = creditCardService.saveAll(creditCards);
		if (list != null && list.size() > 0) {
			long count = list.stream().filter(cc->cc.getErrorMessageMap().hasErrorMsgs()).count();
			if (count > 0) {
				return new ResponseEntity<List<CreditCard>>(list, HttpStatus.BAD_REQUEST);
				//try to send below response but data returning empty
//				return new ResponseEntity<List<CreditCard>>(list, HttpStatus.NOT_MODIFIED);
			}
		}
		return new ResponseEntity<List<CreditCard>>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody CreditCard creditCard) throws Exception {
		String message = creditCardService.update(creditCard);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "creditCardId") ObjectId creditCardId) throws Exception {
		String message = creditCardService.deleteById(creditCardId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getCreditCardById")
	public @ResponseBody ResponseEntity<Object> getCreditCardById(@RequestParam(required = true, value = "creditCardId") ObjectId creditCardId) throws Exception {
		CreditCard byId = creditCardService.getCreditCardById(creditCardId);
		return new ResponseEntity<Object>(byId, HttpStatus.OK);
	}
}
