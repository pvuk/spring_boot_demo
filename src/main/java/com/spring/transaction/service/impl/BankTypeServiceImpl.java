package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.BankType;
import com.spring.transaction.repository.BankTypeRepository;
import com.spring.transaction.service.BankTypeService;
import com.spring.transaction.validator.CodeTableConstants;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class BankTypeServiceImpl implements BankTypeService {
	
	@Autowired private MongoTemplate mongoTemplate;
	@Autowired private BankTypeRepository bankTypeMongoRepo;
//	@Autowired private MongoConfig mongoConfig;
	
	@Override
	public String save(BankType bankType) throws Exception {
		
		return MessageConstants.WORKING_IN_PROGRESS + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
	}

	@Override
	public List<BankType> saveAll(List<BankType> bankTypes) throws Exception {
		bankTypes.forEach(bankType -> {
			Query query = Query.query(Criteria.where(CodeTableConstants.Column.CODE).is(bankType.getCode()));
			boolean exists = mongoTemplate.exists(query, BankType.class);
			log.info(query.toString());
			if (!exists) {
//				int projectId = 100;
//		        if (projectId != 0) {
//		            mongoTemplate = mongoConfig.fetchMongoTemplate(100);
//		            mongoTemplate.setSessionSynchronization(SessionSynchronization.ALWAYS);
//		            log.info("mongoTemplate <{}>", mongoTemplate.getDb().getName());
//		        }
				bankTypeMongoRepo.insert(bankType);
			} else {
				log.info(bankType.getDescription() +" already exist.");
				bankType.getErrorMessageMap().putErrorMsg(MessageConstants.STATUS.WARNING, bankType.getDescription() +" already exist.");
			}
		});
		return bankTypes;
	}

	@Override
	public String update(BankType bankType) throws Exception {
		
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
