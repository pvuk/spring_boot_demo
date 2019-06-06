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
import com.spring.transaction.model.MerchantDetails;
import com.spring.transaction.service.MerchantDetailsService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/merchantDetails/custom/")
public class MerchantDetailsController {
	
	@Autowired private MerchantDetailsService merchantDetailsService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) MerchantDetails merchantDetails) throws Exception {
		String message = merchantDetailsService.save(merchantDetails);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<MerchantDetails> merchantDetailss) throws Exception {
		List<MerchantDetails> list = merchantDetailsService.saveAll(merchantDetailss);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody MerchantDetails merchantDetails) throws Exception {
		String message = merchantDetailsService.update(merchantDetails);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteMerchantDetailsById")
	public @ResponseBody ResponseEntity<Object> deleteMerchantDetailsById(@RequestParam(required = true, value = "merchantDetailsId") ObjectId merchantDetailsId) throws Exception {
		String message = merchantDetailsService.deleteMerchantDetailsById(merchantDetailsId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getMerchantDetailsById")
	public @ResponseBody ResponseEntity<Object> getMerchantDetailsById(@RequestParam(required = true, value = "merchantDetailsId") ObjectId merchantDetailsId) throws Exception {
		MerchantDetails MerchantDetails = merchantDetailsService.getMerchantDetailsById(merchantDetailsId);
		return new ResponseEntity<Object>(MerchantDetails, HttpStatus.OK);
	}
}
