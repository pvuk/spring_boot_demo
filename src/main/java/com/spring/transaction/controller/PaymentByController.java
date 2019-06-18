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
import com.spring.transaction.model.PaymentBy;
import com.spring.transaction.service.PaymentByService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/paymentBy/custom/")
public class PaymentByController {
	
	@Autowired private PaymentByService paymentByService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) PaymentBy paymentBy) throws Exception {
		String message = paymentByService.save(paymentBy);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<PaymentBy> paymentBys) throws Exception {
		List<PaymentBy> list = paymentByService.saveAll(paymentBys);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody PaymentBy paymentBy) throws Exception {
		String message = paymentByService.update(paymentBy);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "paymentById") ObjectId paymentById) throws Exception {
		String message = paymentByService.deleteById(paymentById);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getPaymentByById")
	public @ResponseBody ResponseEntity<Object> getPaymentByById(@RequestParam(required = true, value = "paymentById") ObjectId paymentById) throws Exception {
		PaymentBy PaymentBy = paymentByService.getPaymentByById(paymentById);
		return new ResponseEntity<Object>(PaymentBy, HttpStatus.OK);
	}
}
