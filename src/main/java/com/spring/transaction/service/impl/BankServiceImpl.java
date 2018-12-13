package com.spring.transaction.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.mongo.BankMongoRepository;
import com.spring.transaction.service.BankService;
import com.spring.transaction.validator.ErrorMessages;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class BankServiceImpl implements BankService {
	
	private BankMongoRepository bankMongoRepo;

	@Override
	public String saveBank(Bank bank) {
		bank = bankMongoRepo.save(bank);
		return MessageConstants.SUCCESS_SAVE;
	}

	@Override
	public String updateBank(Bank bank) throws Exception {
		if (bank != null && bank.getBankId() != 0L) {
			bank = bankMongoRepo.save(bank);
		} else {
			log.info(ErrorMessages.UPDATE_FAILED);
			throw new Exception(ErrorMessages.UPDATE_FAILED);
		}
		return MessageConstants.SUCCESS_UPDATE;
	}

	@Override
	public String deleteBankById(long bankId) {
		bankMongoRepo.deleteById(bankId);
		return MessageConstants.SUCCESS_DELETE;
	}

	@Override
	public Bank findByBankId(long bankId) {
		return bankMongoRepo.findById(bankId).get();
	}

}
