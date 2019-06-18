package com.spring.transaction.controller;

import java.util.List;

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

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.Wallet;
import com.spring.transaction.service.WalletService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@BasePathAwareController
@RequestMapping(value = "/wallet/custom")
public class WalletController {

	@Autowired private WalletService walletService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) Wallet wallet) throws Exception {
		String message = walletService.save(wallet);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<Wallet> wallets) throws Exception {
		List<Wallet> list = walletService.saveAll(wallets);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody Wallet wallet) throws Exception {
		String message = walletService.update(wallet);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "walletId") ObjectId walletId) throws Exception {
		String message = walletService.deleteById(walletId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getById")
	public @ResponseBody ResponseEntity<Object> getById(@RequestParam(required = true, value = "walletId") ObjectId walletId) throws Exception {
		Wallet byId = walletService.getById(walletId);
		return new ResponseEntity<Object>(byId, HttpStatus.OK);
	}
}
