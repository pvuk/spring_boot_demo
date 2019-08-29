package com.spring.transaction.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.transaction.model.CreditCardStatement;
import com.spring.transaction.service.CreditCardStatementService;

@BasePathAwareController
@RequestMapping(value = "/creditCardStatement/custom")
public class CreditCardStatementController {
	
	@Autowired private CreditCardStatementService ccStatementService;
	
	@PostMapping(value="/uploadStatement/{password}", consumes = {"multipart/form-data"})
	public @ResponseBody ResponseEntity<Object> uploadStatement(@RequestParam(name = "file") MultipartFile file,
			@PathVariable(name = "password") String password) throws IOException {
		CreditCardStatement ccStatement = ccStatementService.uploadStatement(file, password);
		return new ResponseEntity<Object>(ccStatement, HttpStatus.OK);
	}
}
