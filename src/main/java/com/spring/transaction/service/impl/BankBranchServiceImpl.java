package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.spring.transaction.service.CRUDOperationService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Qualifier(value="bankBranchService")
public class BankBranchServiceImpl implements CRUDOperationService, BankBranchService {

	@Autowired private MongoTemplate mongoTemplate;
	
	@Autowired private BankRepository bankMongoRepo;
	@Autowired private BankBranchRepository bankBranchMongoRepo;
	
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

	@Override
	public String save(Object insert) throws Exception {
		try {
			log.info("saveBankBranch - START");
			
			BankBranch bankBranch = (BankBranch) insert;
			Bank bank = bankBranch.getBank();
			String bankName = bank.getBankName();
			Bank findByBankName = bankMongoRepo.findByBankName(bankName);
			if (findByBankName == null) {
				mongoTemplate.insert(bank);
			} else if (findByBankName != null && findByBankName.getBankId() != null) {
				bank = findByBankName;
			}
			bankBranch.setBank(bank);
			
			String branch = bankBranch.getBranchName();
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
				CurrentAddress currentAddress = address.getCurrentAddress();
				
				if (permanentAddress != null || currentAddress != null) {
					
					if (address.getIsPermanentAddressIsSameAsCurrentAddress()) {
						BeanUtils.copyProperties(permanentAddress, currentAddress);
						currentAddress.setIsActiveCurrentAddress(true);
					}
					
					if (permanentAddress != null) {
						permanentAddress.setIsActivePermanentAddress(true);
						PermanentAddress pA = mongoTemplate.insert(permanentAddress);
						address.setPermanentAddressId(pA.getPermanentAddressId());
					}
					
					if (currentAddress != null){
						currentAddress.setIsActiveCurrentAddress(true);
						CurrentAddress cA = mongoTemplate.insert(currentAddress);
						address.setCurrentAddressId(cA.getCurrentAddressId());
					}
					mongoTemplate.insert(address);
				}
				bankBranch.setAddress(address);
			}
			bankBranchMongoRepo.save(bankBranch);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			log.info("saveBankBranch - END");
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public List<Object> saveAll(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object id, Object update) throws Exception {

		return MessageConstants.WORKING_IN_PROGRESS + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
	}

	@Override
	public String deleteById(ObjectId id) throws Exception {
		try {
			bankBranchMongoRepo.deleteById(id);
		} catch (Exception e) {
			log.error("deleteById: {}, Cause: {}", id, e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

	@Override
	public Object getById(ObjectId id) {
		try {
			Optional<BankBranch> byId = bankBranchMongoRepo.findById(id);
			return byId.isPresent() ? byId.get() : null;
		} catch (Exception e) {
			log.error("BankBranchId "+ id +" not found. Cause: "+ e.getMessage());
			throw new NotFoundException("BankBranchId "+ id +" not found. Cause: "+ e.getMessage());
		}
	}

}
