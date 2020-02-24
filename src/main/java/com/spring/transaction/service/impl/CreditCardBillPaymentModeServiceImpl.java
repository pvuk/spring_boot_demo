package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.spring.transaction.model.BankType;
import com.spring.transaction.model.CreditCardBillPaymentMode;
import com.spring.transaction.service.CreditCardBillPaymentModeService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreditCardBillPaymentModeServiceImpl implements CreditCardBillPaymentModeService{

	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public CreditCardBillPaymentMode getById(ObjectId getById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(CreditCardBillPaymentMode save) throws Exception {
		try {
			if (save.getCreditCardBillPaymentModeId() == null) {
				CreditCardBillPaymentMode findOne = mongoTemplate.findOne(new Query(Criteria.where("DESCRIPTION").is(save.getDescription())), CreditCardBillPaymentMode.class);
				if (findOne == null || findOne.getCreditCardBillPaymentModeId() == null) {
					mongoTemplate.insert(save);
				} else {
					log.warn("Credit Card Bill Payment Mode: {} is trying to save the record.", save.getDescription());
					throw new Exception(MessageConstants.Failed.SAVE +" Cause: Credit Card Bill Payment Mode '"+ save.getDescription() +"' is trying to save the record.");
				}
			} else {
				log.warn("Credit Card Bill Payment Mode: {} is trying to update the record.", save.getDescription());
				throw new Exception(MessageConstants.Failed.SAVE +" Cause: Credit Card Bill Payment Mode '"+ save.getDescription() +"' is trying to update the record.");
			}
		} catch (Exception e) {
			log.error("save: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.SAVE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public List<BankType> saveAll(List<CreditCardBillPaymentMode> saveList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CreditCardBillPaymentMode update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String updateAll(List<CreditCardBillPaymentMode> updateList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId deleteById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
