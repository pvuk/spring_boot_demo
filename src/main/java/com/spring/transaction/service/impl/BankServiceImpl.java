package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.BankRepository;
import com.spring.transaction.service.BankService;
import com.spring.transaction.validator.ErrorMessages;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class BankServiceImpl implements BankService {
	
	@Autowired private BankRepository bankMongoRepo;

//	@Autowired private MongoClient mongoClient;
	
	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public String saveBank(Bank bank) throws Exception {
		/*try {
			MongoDatabase db = mongoClient.getDatabase("trans");
			MongoCollection<Document> dbCollection = db.getCollection("BANK_CODE");
			Document dbObject2 = Document.parse(bank.toString());
			dbCollection.insertOne(dbObject2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}*/
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
	public String deleteBankById(String bankId) {
		ObjectId objectId = new ObjectId(bankId);
		bankMongoRepo.deleteById(objectId);
		return MessageConstants.SUCCESS_DELETE;
	}

	@Override
	public Bank findByBankId(String bankId) {
		ObjectId objectId = new ObjectId(bankId);
		Optional<Bank> findById = bankMongoRepo.findById(objectId);
		if (findById.isPresent()) {
			log.error("BankId: "+ bankId +" Not found");
			throw new NotFoundException("BankId: "+ bankId +" Not found");
		}
		return bankMongoRepo.findById(objectId).get();
	}

	@Override
	public List<Bank> getAllBanks() {
		List<Bank> list = bankMongoRepo.findAll();
		return list;
	}

	@Override
	public List<Bank> saveAllBanks(List<Bank> banks) throws Exception{
		banks.forEach(bank -> {
			Query query = Query.query(Criteria.where("BANK_NAME").is(bank.getBankName()));
			boolean exists = mongoTemplate.exists(query, Bank.class);
			if (!exists) {
				bankMongoRepo.insert(bank);
			} else {
				log.info(bank.getBankName() +" already exist.");
				bank.getErrorMessageMap().putErrorMsg(bank.getBankName(), bank.getBankName() +" already exist.");
			}
		});
		return banks;
	}

}
