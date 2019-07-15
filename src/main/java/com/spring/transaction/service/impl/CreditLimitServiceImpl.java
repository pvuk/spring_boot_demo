package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CardLimit;
import com.spring.transaction.repository.CardLimitRepository;
import com.spring.transaction.service.CardLimitService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
@Slf4j
public class CreditLimitServiceImpl implements CardLimitService {

	@Autowired private CardLimitRepository creditLimitRepo;
	
	@Override
	public CardLimit getCreditLimitById(ObjectId cardLimitId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(CardLimit cardLimit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardLimit> saveAll(List<CardLimit> cardLimits) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CardLimit cardLimit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId cardLimitId) throws Exception {
		try {
			creditLimitRepo.deleteById(cardLimitId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
