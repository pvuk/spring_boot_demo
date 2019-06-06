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
import com.spring.transaction.model.CreditLimit;
import com.spring.transaction.service.CreditLimitService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/creditLimit/custom/")
public class CreditLimitController {

	@Autowired private CreditLimitService creditLimitService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) CreditLimit creditLimit) throws Exception {
		String message = creditLimitService.save(creditLimit);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<CreditLimit> creditLimits) throws Exception {
		List<CreditLimit> list = creditLimitService.saveAll(creditLimits);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody CreditLimit creditLimit) throws Exception {
		String message = creditLimitService.update(creditLimit);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteCreditLimitById")
	public @ResponseBody ResponseEntity<Object> deleteCreditLimitById(@RequestParam(required = true, value = "creditLimitId") ObjectId creditLimitId) throws Exception {
		String message = creditLimitService.deleteCreditLimitById(creditLimitId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getCreditLimitById")
	public @ResponseBody ResponseEntity<Object> getCreditLimitById(@RequestParam(required = true, value = "creditLimitId") ObjectId creditLimitId) throws Exception {
		CreditLimit CreditLimit = creditLimitService.getCreditLimitById(creditLimitId);
		return new ResponseEntity<Object>(CreditLimit, HttpStatus.OK);
	}
}
