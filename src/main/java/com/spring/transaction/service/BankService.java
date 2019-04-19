package com.spring.transaction.service;

import java.util.List;

import com.spring.transaction.model.Bank;

public interface BankService {
	
	String saveBank(Bank bank) throws Exception;
	
	String saveAllBanks(List<Bank> banks) throws Exception;
	
	String updateBank(Bank bank) throws Exception;
	
	String deleteBankById(String bankId);
	
	Bank findByBankId(String bankId);
	
	List<Bank> getAllBanks();
}
