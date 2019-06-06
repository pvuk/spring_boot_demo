package com.spring.transaction.service;

import java.util.List;

import com.spring.transaction.model.Bank;

public interface BankService {
	
	String save(Bank bank) throws Exception;
	
	List<Bank> saveAll(List<Bank> banks) throws Exception;
	
	String update(Bank bank) throws Exception;
	
	String deleteBankById(String bankId);
	
	Bank findByBankId(String bankId);
	
	List<Bank> getAllBanks();
}
