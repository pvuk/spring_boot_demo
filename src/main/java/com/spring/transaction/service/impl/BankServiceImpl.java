package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Bank;
import com.spring.transaction.repository.BankRepository;
import com.spring.transaction.service.BankService;
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
@Qualifier(value="bankService")
public class BankServiceImpl implements CRUDOperationService, BankService {
	
	@Autowired private BankRepository bankMongoRepo;

//	@Autowired private MongoConfig mongoConfig;
	
	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public List<Bank> getAllBanks() {
		List<Bank> list = bankMongoRepo.findAll();
		return list;
	}

	@Override
	public String save(Object insert) throws Exception {
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
	public List<Object> saveAll(List<Object> list) throws Exception {
		List<Bank> banks = new ObjectMapper().convertValue(list, new TypeReference<List<Bank>>() {
		});
		banks.forEach(obj -> {
			Bank bank = obj;
			Query query = Query.query(Criteria.where("BANK_NAME").is(bank.getBankName()));
			boolean exists = mongoTemplate.exists(query, Bank.class);
			if (!exists) {
				bank = bankMongoRepo.insert(bank);
			} else {
				log.info("saveAll: {} already exist.", bank.getBankName());
				bank.getErrorMessageMap().putErrorMsg(MessageConstants.Status.WARNING, bank.getBankName() +" already exist.");
			}
		});
//		Map<String, Bank> bankMap = banks.stream().filter(b -> b.getBankId() != null).collect(Collectors.toMap(Bank::getBankId, b -> b));
////		list.stream().collect(Collectors.to)
//		list.forEach(b->{
//			LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>) b;
//			lhm.entrySet().forEach(entry-> {
//				if(lhm.containsKey("bankName")) {
//					lhm.put("id", bankMap.get(entry.getKey()).getBankId());
//				}
//			});
//		});
		return list;
	}

	@Override
	public String update(Object update) throws Exception {
		Bank bank = (Bank) update;
		if (bank != null && bank.getBankId() != null) {
			bank = bankMongoRepo.save(bank);
		} else {
			log.info("updateBank: {}, for bankId: {}", MessageConstants.Failed.UPDATE, bank.getBankId());
			throw new Exception(MessageConstants.Failed.UPDATE);
		}
		return MessageConstants.Success.UPDATE;
	}
	
	@Override
	public String deleteById(ObjectId id) {
		bankMongoRepo.deleteById(id);
		return MessageConstants.Success.DELETE;
	}

	@Override
	public Object getById(ObjectId id) {
		Optional<Bank> findById = bankMongoRepo.findById(id);
		if (!findById.isPresent()) {
			log.error("BankId: "+ id +" Not found. "+ MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
			throw new NotFoundException("BankId: "+ id +" Not found. "+ MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
		}
		return bankMongoRepo.findById(id).get();
	}
}
