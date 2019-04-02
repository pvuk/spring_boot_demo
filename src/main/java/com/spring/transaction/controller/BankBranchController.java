package com.spring.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.BankBranch;
import com.spring.transaction.service.BankBranchService;

@BasePathAwareController
@RequestMapping(value="/bankBranch/service/")
public class BankBranchController {
	
	@Autowired private BankBranchService bankBranchService;
	
	@PostMapping(path = "/saveBankBranch")
	public @ResponseBody ResponseEntity<Object> saveBankBranch(@RequestBody(required=true) BankBranch bankBranch) throws Exception {
		String message = bankBranchService.saveBankBranch(bankBranch);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/getBankBranchIds")
	public @ResponseBody ResponseEntity<Object> getBankBranchIds(@RequestBody(required=true) List<String> bankBranchIds) throws Exception {
		return new ResponseEntity<Object>(bankBranchIds, HttpStatus.OK);
	}
}
