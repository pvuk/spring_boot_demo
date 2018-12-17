package com.spring.transaction.service;

import java.util.List;

import com.spring.transaction.model.Bank;

public interface BankService {
	
	String saveBank(Bank bank);
	String updateBank(Bank bank) throws Exception;
	String deleteBankById(long bankId);
	
	Bank findByBankId(long bankId);
	List<Bank> getAllBanks();
}
