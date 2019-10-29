package com.spring.transaction.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.BankBranch;
import com.spring.transaction.service.CRUDOperationService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@BasePathAwareController
@RequestMapping(value="/bankBranch/custom/")
public class BankBranchController {
	
//	@Autowired private BankBranchService bankBranchService;
	
	@Qualifier(value="bankBranchService")
	@Autowired private CRUDOperationService crudOperationService;
	
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) BankBranch bankBranch) throws Exception {
		String message = crudOperationService.save(bankBranch);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	/**
	 * <p>
	 * If you call below service as GET then 405 status will return. Because you are
	 * calling GET but this service allows POST
	 * </p> 
	 * <b>Status: </b>405 Method Not Allowed
	 * <p>
	 * A request was made of a resource using a request method not supported by that
	 * resource; for example using GET on a form which requires data to be presented
	 * via POST, or using PUT on a read-only resource
	 * </p>
	 * 
	 * @param bankBranchId
	 * @return bankBranch
	 * @throws Exception
	 */
	@PostMapping(path = "/getById")
	public @ResponseBody ResponseEntity<Object> getById(@RequestBody(required=true) ObjectId bankBranchId) throws Exception {
		Object bankBranch = crudOperationService.getById(bankBranchId);
		return new ResponseEntity<Object>(bankBranch, HttpStatus.OK);
	}
}
