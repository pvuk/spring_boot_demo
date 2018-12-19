package com.spring.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Bank;
import com.spring.transaction.service.BankService;

@Controller
@RequestMapping("/bank/service")
public class BankController {
	
	@Autowired private BankService bankService;
	
	@PostMapping(path = "/saveBank")
	public @ResponseBody ResponseEntity<Object> saveBank(@RequestBody(required=true) Bank bank) {
		String message = bankService.saveBank(bank);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}

	@PostMapping(path = "/updateBank")
	public @ResponseBody ResponseEntity<Object> updateBank(@RequestBody Bank bank) throws Exception {
		String message = bankService.updateBank(bank);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteBankById")
	public @ResponseBody ResponseEntity<Object> deleteBankById(@RequestParam(required = true, value = "bankId") long bankId) {
		String message = bankService.deleteBankById(bankId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	@GetMapping(path = "/findByBankId")
	public @ResponseBody ResponseEntity<Object> findByBankId(@RequestParam(required = true, value = "bankId") long bankId) {
		Bank bank = bankService.findByBankId(bankId);
		return new ResponseEntity<Object>(bank, HttpStatus.OK);
	}
	
	@RequestMapping(path="/getAllBanks")
	public @ResponseBody ResponseEntity<Object> getAllBanks(){
		List<Bank> banks = bankService.getAllBanks();
		return new ResponseEntity<Object>(banks, HttpStatus.OK);
	}
}
