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
public class BankServiceImpl implements BankService {
	
	@Autowired private BankRepository bankMongoRepo;

//	@Autowired private MongoConfig mongoConfig;
	
	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public String save(Bank bank) throws Exception {
		try {
//			MongoCollection<Document> bankCollection = mongoConfig.getCollection("BANK_CODE");
//			
//			MongoCollection<Document> bankTypeCollection = mongoConfig.getCollection("BANK_TYPE_CODE");
//			Bson eq = Filters.eq("BANK_TYPE_CODE.CODE", bank.getBankType().getCode());
//			BankType bankType = bankTypeCollection.find(eq, BankType.class).first();
//			if (bankType != null && bankType.getId() != null) {
//				bank.getBankType().setId(bankType.getId());
//			}
//			Document bankDocument = Document.parse(bank.toString());
			
//			bankCollection.insertOne(bankDocument);
		} catch (Exception e) {
			log.error("save: {}", e);
			throw new Exception(MessageConstants.Failed.SAVE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public String update(Bank bank) throws Exception {
		if (bank != null && bank.getBankId() != null) {
			bank = bankMongoRepo.save(bank);
		} else {
			log.info("updateBank: {}, for bankId: {}", MessageConstants.Failed.UPDATE, bank.getBankId());
			throw new Exception(MessageConstants.Failed.UPDATE);
		}
		return MessageConstants.Success.UPDATE;
	}

	@Override
	public String deleteBankById(String bankId) {
		ObjectId objectId = new ObjectId(bankId);
		bankMongoRepo.deleteById(objectId);
		return MessageConstants.Success.DELETE;
	}

	@Override
	public Bank findByBankId(String bankId) {
		ObjectId objectId = new ObjectId(bankId);
		Optional<Bank> findById = bankMongoRepo.findById(objectId);
		if (findById.isPresent()) {
			log.error("BankId: "+ bankId +" Not found");
			throw new NotFoundException("BankId: "+ bankId +" Not found. "+ MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
		}
		return bankMongoRepo.findById(objectId).get();
	}

	@Override
	public List<Bank> getAllBanks() {
		List<Bank> list = bankMongoRepo.findAll();
		return list;
	}

	@Override
	public List<Bank> saveAll(List<Bank> banks) throws Exception{
		banks.forEach(bank -> {
			Query query = Query.query(Criteria.where("BANK_NAME").is(bank.getBankName()));
			boolean exists = mongoTemplate.exists(query, Bank.class);
			if (!exists) {
				bankMongoRepo.insert(bank);
			} else {
				log.info(bank.getBankName() +" already exist.");
				bank.getErrorMessageMap().putErrorMsg(MessageConstants.Status.WARNING, bank.getBankName() +" already exist.");
			}
		});
		return banks;
	}

}
