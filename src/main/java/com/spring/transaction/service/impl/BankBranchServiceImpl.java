package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Address;
import com.spring.transaction.model.Bank;
import com.spring.transaction.model.BankBranch;
import com.spring.transaction.model.CurrentAddress;
import com.spring.transaction.model.PermanentAddress;
import com.spring.transaction.repository.BankBranchRepository;
import com.spring.transaction.repository.BankRepository;
import com.spring.transaction.service.BankBranchService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BankBranchServiceImpl implements BankBranchService {

	@Autowired private MongoTemplate mongoTemplate;
	
	@Autowired private BankRepository bankMongoRepo;
	@Autowired private BankBranchRepository bankBranchMongoRepo;
	
	@Override
	public String saveBankBranch(BankBranch bankBranch) throws Exception {
		try {
			log.info("Start - saveBankBranch");
			
			Bank bank = bankBranch.getBank();
			String bankName = bank.getBankName();
			Bank findByBankName = bankMongoRepo.findByBankName(bankName);
			if (findByBankName == null) {
				mongoTemplate.insert(bank);
			} else if (findByBankName != null && findByBankName.getBankId() != null) {
				bank = findByBankName;
			}
			bankBranch.setBank(bank);
			
			String branch = bankBranch.getBranch();
			if (bankBranch != null && !StringUtils.isEmpty(branch)) {
				BankBranch findByBranch = bankBranchMongoRepo.findByBranch(branch);
				if (findByBranch != null) {
					log.error(bankName +" Branch: "+ branch +" Already exsit");
					throw new Exception(bankName +" Branch: "+ branch +" Already exsit");
				}
			}
			Address address = bankBranch.getAddress();
			if (address != null) {
				PermanentAddress permanentAddress = address.getPermanentAddress();
				mongoTemplate.insert(permanentAddress);
				
				CurrentAddress currentAddress = address.getCurrentAddress();
				mongoTemplate.insert(currentAddress);
				
				if (permanentAddress != null && permanentAddress.getPermanentAddressId() != null) {
					address.setCurrentAddress(currentAddress);
					address.setPermanentAddress(permanentAddress);
					mongoTemplate.insert(address);
					log.info("Saving Address for BankBranch: {}", currentAddress);
				}
				bankBranch.setAddress(address);
			}
			bankBranchMongoRepo.save(bankBranch);
			log.info("End - saveBankBranch");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public String updateBankBranch(BankBranch bankBranch) throws Exception {

		return MessageConstants.WORKING_IN_PROGRESS + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
	}

	@Override
	public String deleteBankBranchById(ObjectId bankBranchId) {

		return MessageConstants.WORKING_IN_PROGRESS + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
	}

	@Override
	public BankBranch findByBankBranchId(ObjectId bankBranchId) {
		try {
			Optional<BankBranch> byId = bankBranchMongoRepo.findById(bankBranchId);
			return byId.isPresent() ? byId.get() : null;
		} catch (Exception e) {
			log.error("findByBankBranchId: {} not found. Cause: {}", bankBranchId, e.getMessage());
			throw new NotFoundException("BankBranchId "+ bankBranchId +" not found. Cause: "+ e.getMessage());
		}
	}

	@Override
	public List<BankBranch> getAllBankBranches() {
		List<BankBranch> list = null;
		try {
			list = bankBranchMongoRepo.findAll();
		} catch (Exception e) {
			log.error("getAllBankBranches: {}", e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return list;
	}

}
