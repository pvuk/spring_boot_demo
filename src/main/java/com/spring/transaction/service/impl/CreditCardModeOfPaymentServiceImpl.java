package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.spring.transaction.model.BankType;
import com.spring.transaction.model.CreditCardModeOfPayment;
import com.spring.transaction.service.CreditCardModeOfPaymentService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreditCardModeOfPaymentServiceImpl implements CreditCardModeOfPaymentService{

	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public CreditCardModeOfPayment getById(ObjectId getById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(CreditCardModeOfPayment save) throws Exception {
		try {
			if (save.getCreditCardModeOfPaymentId() == null) {
				CreditCardModeOfPayment findOne = mongoTemplate.findOne(new Query(Criteria.where("MODE_OF_PAYMENT").is(save.getModeOfPayment())), CreditCardModeOfPayment.class);
				if (findOne == null || findOne.getCreditCardModeOfPaymentId() == null) {
					mongoTemplate.insert(save);
				} else {
					log.warn("CreditCardModeOfPayment: {} is trying to save the record.", save.getModeOfPayment());
					throw new Exception(MessageConstants.Failed.SAVE +" Cause: Credit Card Mode Of Payment '"+ save.getModeOfPayment() +"' is trying to save the record.");
				}
			} else {
				log.warn("CreditCardModeOfPayment: {} is trying to update the record.", save.getModeOfPayment());
				throw new Exception(MessageConstants.Failed.SAVE +" Cause: Credit Card Mode Of Payment '"+ save.getModeOfPayment() +"' is trying to update the record.");
			}
		} catch (Exception e) {
			log.error("save: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.SAVE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public List<BankType> saveAll(List<CreditCardModeOfPayment> saveList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CreditCardModeOfPayment update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String updateAll(List<CreditCardModeOfPayment> updateList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId deleteById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
