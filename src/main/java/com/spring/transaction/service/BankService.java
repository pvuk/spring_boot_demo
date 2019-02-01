package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.Bank;

public interface BankService {
	
	String saveBank(Bank bank) throws Exception;
	String updateBank(Bank bank) throws Exception;
	String deleteBankById(ObjectId bankId);
	
	Bank findByBankId(ObjectId bankId);
	List<Bank> getAllBanks();
}
