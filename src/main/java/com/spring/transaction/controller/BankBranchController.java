package com.spring.transaction.controller;

import org.bson.types.ObjectId;
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

/**
 * 
 * @author venkataudaykiranp
 *
 */
@BasePathAwareController
@RequestMapping(value="/bankBranch/custom/")
public class BankBranchController {
	
	@Autowired private BankBranchService bankBranchService;
	
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) BankBranch bankBranch) throws Exception {
		String message = bankBranchService.save(bankBranch);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/getBankBranchById")
	public @ResponseBody ResponseEntity<Object> getBankBranchById(@RequestBody(required=true) ObjectId bankBranchId) throws Exception {
		BankBranch bankBranch = bankBranchService.getBankBranchById(bankBranchId);
		return new ResponseEntity<Object>(bankBranch, HttpStatus.OK);
	}
}
