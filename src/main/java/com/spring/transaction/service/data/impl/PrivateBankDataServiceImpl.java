package com.spring.transaction.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.BankRepository;
import com.spring.transaction.service.data.BankDataService;
import com.spring.transaction.util.CodeTableConstants;

@Component
@Qualifier(value = CodeTableConstants.Bean.PRIVATE_BANK_BANKTYPE)
public class PrivateBankDataServiceImpl implements BankDataService {

	@Autowired private BankRepository bankRepository;
	
	/**
	 * Example 1: Find collections by Nested Object's objectId in Spring Data using repository interface.
	 * 
	 * @return list
	 */
	@Override
	public List<Bank> getBanks() {
		List<Bank> list = bankRepository.findByBankTypeId(CodeTableConstants.Bank.BANK_ID_VALUE);//Example 1
		return list;
	}

}
