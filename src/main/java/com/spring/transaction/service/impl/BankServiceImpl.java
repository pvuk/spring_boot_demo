package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.mongo.BankMongoRepository;
import com.spring.transaction.service.BankService;
import com.spring.transaction.validator.ErrorMessages;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BankServiceImpl implements BankService {
	
	@Autowired private BankMongoRepository bankMongoRepo;

	@Autowired private MongoClient mongoClient;
	
	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public String saveBank(Bank bank) throws Exception {
		try {
			@SuppressWarnings("deprecation")
			DB db = mongoClient.getDB("trans");
			DBCollection dbCollection = db.getCollection("BANK_CODE");
			BasicDBObject dbObject2 = BasicDBObject.parse(bank.toString());
			dbCollection.insert(dbObject2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return MessageConstants.SUCCESS_SAVE;
	}

	@Override
	public String updateBank(Bank bank) throws Exception {
		if (bank != null && bank.getBankId() != null) {
			bank = bankMongoRepo.save(bank);
		} else {
			log.info(ErrorMessages.UPDATE_FAILED);
			throw new Exception(ErrorMessages.UPDATE_FAILED);
		}
		return MessageConstants.SUCCESS_UPDATE;
	}

	@Override
	public String deleteBankById(ObjectId bankId) {
		bankMongoRepo.deleteById(bankId);
		return MessageConstants.SUCCESS_DELETE;
	}

	@Override
	public Bank findByBankId(ObjectId bankId) {
		Optional<Bank> findById = bankMongoRepo.findById(bankId);
		if (findById.isPresent()) {
			throw new NotFoundException("BankId "+ bankId +" Not found");
		}
		return bankMongoRepo.findById(bankId).get();
	}

	@Override
	public List<Bank> getAllBanks() {
		return bankMongoRepo.findAll();
	}

}
