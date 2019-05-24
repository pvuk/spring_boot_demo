package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.model.BankType;
import com.spring.transaction.service.BankTypeService;

@BasePathAwareController
@RequestMapping("/bankType/service")
public class BankTypeController {

	@Autowired
	BankTypeService bankTypeService;

	@GetMapping(value = "/saveBankType")
	public @ResponseBody String saveBankType(BankType bankType) throws Exception {
		return bankTypeService.saveBankType(bankType);
	}

	@PutMapping(value = "/saveAllBankTypes")
	public @ResponseBody ResponseEntity<List<BankType>> saveAllBankTypes(@RequestBody List<BankType> bankTypes) throws Exception {
		List<BankType> list = null;
		try {
			list = bankTypeService.saveAllBankTypes(bankTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<BankType>>(list, HttpStatus.CREATED);
	}

	@PostMapping(value = "/updateBankType")
	public @ResponseBody String updateBankType(BankType bankType) throws Exception {
		return null;

	}

	@DeleteMapping(value = "/deleteBankTypeById/{bankTypeId}")
	public @ResponseBody String deleteBankTypeById(
			@PathVariable(required = true, name = "bankTypeId") ObjectId bankTypeId) {
		return bankTypeService.deleteBankTypeById(bankTypeId);
	}
}
