package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.configuration.MongoConfig;
import com.spring.transaction.model.BankType;
import com.spring.transaction.repository.BankTypeRepository;
import com.spring.transaction.service.BankTypeService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class BankTypeServiceImpl implements BankTypeService {
	
	@Autowired private MongoTemplate mongoTemplate;
	@Autowired private BankTypeRepository bankTypeMongoRepo;
	@Autowired private MongoConfig mongoConfig;
	
	@Override
	public String saveBankType(BankType bankType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankType> saveAllBankTypes(List<BankType> bankTypes) throws Exception {
		Query query = new Query();
		bankTypes.forEach(bankType -> {
			query.addCriteria(Criteria.where("code").is(bankType.getCode()));
			boolean exists = mongoTemplate.exists(query, BankType.class);
			if (!exists) {
				bankTypeMongoRepo.insert(bankType);
			} else {
				log.error(bankType.getCode() +" not inserted.");
//				bankType.getErrorMessageMap().putErrorMsg(bankType.getCode(), bankType.getCode() +" not inserted.");
			}
		});
		return bankTypes;
	}

	@Override
	public String updateBankType(BankType bankType) throws Exception {
		
		return MessageConstants.WORKING_IN_PROGRESS + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
	}

	@Override
	public String deleteBankTypeById(ObjectId bankTypeId) {
		//record not deleted. please work on below code
//		MongoCollection<org.bson.Document> dbCollection = mongoConfig.getCollection(CodeTableConstants.Entity.BANK_TYPE);
//		DeleteResult deleteOne = dbCollection.deleteOne(Filters.eq(CodeTableConstants.Column.BANK_TYPE_ID, bankTypeId));
//		return deleteOne.getDeletedCount() == 0 ? MessageConstants.SUCCESS_DELETE : MessageConstants.ERROR_MESSAGE;

		bankTypeMongoRepo.deleteById(bankTypeId);
		return MessageConstants.SUCCESS_DELETE;
		
//		Query query = new Query().addCriteria(Criteria.where("BANK_TYPE_ID").is(bankTypeId));
//		DeleteResult result = mongoTemplate.remove(query, BankType.class);
//		return result.getDeletedCount() == 0 ? MessageConstants.SUCCESS_DELETE : MessageConstants.ERROR_MESSAGE;
	}

}
