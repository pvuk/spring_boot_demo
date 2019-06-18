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
import com.spring.transaction.model.Cashback;
import com.spring.transaction.service.CashbackService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/cashback/custom/")
public class CashbackController {
	
	@Autowired private CashbackService cashbackService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) Cashback cashback) throws Exception {
		String message = cashbackService.save(cashback);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<Cashback> cashbacks) throws Exception {
		List<Cashback> list = cashbackService.saveAll(cashbacks);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody Cashback cashback) throws Exception {
		String message = cashbackService.update(cashback);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "cashbackId") ObjectId cashbackId) throws Exception {
		String message = cashbackService.deleteById(cashbackId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getCashbackById")
	public @ResponseBody ResponseEntity<Object> getCashbackById(@RequestParam(required = true, value = "cashbackId") ObjectId cashbackId) throws Exception {
		Cashback byId = cashbackService.getCashbackById(cashbackId);
		return new ResponseEntity<Object>(byId, HttpStatus.OK);
	}
}
