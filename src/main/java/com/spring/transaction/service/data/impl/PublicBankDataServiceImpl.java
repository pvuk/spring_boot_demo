package com.spring.transaction.service.data.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.BankRepository;
import com.spring.transaction.service.data.BankDataService;
import com.spring.transaction.util.CodeTableConstants;

@Component
@Primary
@Qualifier(value = CodeTableConstants.Bean.PUBLIC_BANK_BANKTYPE)
public class PublicBankDataServiceImpl implements BankDataService {

	@Autowired
	private BankRepository bankRepository;

	/**
	 * Example 1: filtering Bank list stream based on BankType.Code: public
	 * @return list
	 */
	@Override
	public List<Bank> getBanks() {
		List<Bank> banks = bankRepository.findAll().stream().filter(b -> b.getBankType() != null && b.getBankType().getCode().equals(CodeTableConstants.Bank.CODE_PUBLIC))
				.collect(Collectors.toList());//Example 1
		return banks;
	}

}
