package com.spring.transaction.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.spring.transaction.model.CreditCardStatement;

public interface CreditCardStatementService {
	
	public CreditCardStatement uploadStatement(MultipartFile file, String password) throws IOException;
}
