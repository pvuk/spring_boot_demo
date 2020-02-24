package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.transaction.model.BankType;
import com.spring.transaction.model.CreditCardBillPaymentMode;
import com.spring.transaction.service.CreditCardBillPaymentModeService;

@BasePathAwareController
@RequestMapping(value="/creditCardBillPaymentMode/custom")
public class CreditCardBillPaymentModeController{

	@Autowired private CreditCardBillPaymentModeService ccModeOfPaymentService;
	
	@GetMapping(value="/getById")
	public CreditCardBillPaymentMode getById(ObjectId getById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 1. REST WebService are that POST is often used to create a new entity.
	 * 2. You should use POST to create new resources and PUT to update existing resources.
	 * Example: POST /items create
	 */
	@PostMapping(value="/save")
	public String save(CreditCardBillPaymentMode save) throws Exception {
		String status = ccModeOfPaymentService.save(save);
		return status;
	}

	@PostMapping(value="/saveAll")
	public List<BankType> saveAll(List<CreditCardBillPaymentMode> saveList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 1. PUT is often used to update an existing entity
	 * 2. Use PUT when you know the "id" of the object e.g. Order, Book, Employee
	 * Example: PUT /items/1 update
	 */
	@PutMapping(value="/update")
	public String update(CreditCardBillPaymentMode update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PutMapping(value="/updateAll")
	public String updateAll(List<CreditCardBillPaymentMode> updateList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping(value="/deleteById")
	public String deleteById(ObjectId deleteById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
