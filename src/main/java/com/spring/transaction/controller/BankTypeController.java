package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.BankType;
import com.spring.transaction.service.BankTypeService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@BasePathAwareController
@RequestMapping("/bankType/custom")
public class BankTypeController {

	@Autowired BankTypeService bankTypeService;

	@PutMapping(value = "/save")
	public @ResponseBody String save(@RequestBody BankType bankType) throws Exception {
		return bankTypeService.save(bankType);
	}

	@PutMapping(value = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody List<BankType> bankTypes) throws Exception {
		List<BankType> list = bankTypeService.saveAll(bankTypes);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(value = "/update")
	public @ResponseBody String update(BankType bankType) throws Exception {
		return bankTypeService.update(bankType);
	}

	@DeleteMapping(value = "/deleteBankTypeById/{bankTypeId}")
	public @ResponseBody String deleteBankTypeById(
			@PathVariable(required = true, name = "bankTypeId") ObjectId bankTypeId) throws Exception {
		return bankTypeService.deleteBankTypeById(bankTypeId);
	}
}
