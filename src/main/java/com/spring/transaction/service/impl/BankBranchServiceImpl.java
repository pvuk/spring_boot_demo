package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.spring.transaction.model.Address;
import com.spring.transaction.model.Bank;
import com.spring.transaction.model.BankBranch;
import com.spring.transaction.model.CurrentAddress;
import com.spring.transaction.model.PermanentAddress;
import com.spring.transaction.repository.mongo.BankBranchMongoRepository;
import com.spring.transaction.repository.mongo.BankMongoRepository;
import com.spring.transaction.service.BankBranchService;
import com.spring.transaction.validator.ErrorMessages;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BankBranchServiceImpl implements BankBranchService {

	@Autowired private MongoTemplate mongoTemplate;
	
	@Autowired private BankMongoRepository bankMongoRepository;
	@Autowired private BankBranchMongoRepository bankBranchMongoRepository;
	
	@Override
	public String saveBankBranch(BankBranch bankBranch) throws Exception {
		try {
			log.info("Start - saveBankBranch");
			
			Bank bank = bankBranch.getBank();
			String bankName = bank.getBankName();
			Bank findByBankName = bankMongoRepository.findByBankName(bankName);
			if (findByBankName == null) {
				mongoTemplate.insert(bank);
				log.info("Saving Bank for BankBranch: {}", bank);
			} else if (findByBankName != null && findByBankName.getBankId() != null) {
				bank = findByBankName;
			}
			bankBranch.setBank(bank);
			
			String branch = bankBranch.getBranch();
			if (bankBranch != null && !StringUtils.isEmpty(branch)) {
				BankBranch findByBranch = bankBranchMongoRepository.findByBranch(branch);
				if (findByBranch != null) {
					throw new Exception(bankName +" Branch: "+ branch +" Already exsit");
				}
			}
			Address address = bankBranch.getAddress();
			if (address != null) {
				PermanentAddress permanentAddress = address.getPermanentAddress();
				mongoTemplate.insert(permanentAddress);
				log.info("Saving PermanentAddress of Address for BankBranch: {}", permanentAddress);
				
				CurrentAddress currentAddress = address.getCurrentAddress();
				mongoTemplate.insert(currentAddress);
				log.info("Saving CurrentAddress of Address for BankBranch: {}", currentAddress);
				
				if (permanentAddress != null && permanentAddress.getPermanentAddressId() != null) {
					address.setCurrentAddress(currentAddress);
					address.setPermanentAddress(permanentAddress);
					mongoTemplate.insert(address);
					log.info("Saving Address for BankBranch: {}", currentAddress);
				} else {
					throw new Exception("Something went wrong. "+ ErrorMessages.PLEASE_CONTACT_IT_SUPPORT);
				}
				bankBranch.setAddress(address);
			}
			bankBranchMongoRepository.save(bankBranch);
			log.info("Saved BankBranch: {}", bankBranch);
			log.info("End - saveBankBranch");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return MessageConstants.SUCCESS_SAVE;
	}

	@Override
	public String updateBankBranch(BankBranch bankBranch) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBankBranchById(ObjectId bankBranchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankBranch findByBankBranchId(ObjectId bankBranchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankBranch> getAllBankBranches() {
		// TODO Auto-generated method stub
		return null;
	}

}
