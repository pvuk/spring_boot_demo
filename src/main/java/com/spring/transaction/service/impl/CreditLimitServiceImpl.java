package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CreditLimit;
import com.spring.transaction.repository.CreditLimitRepository;
import com.spring.transaction.service.CreditLimitService;
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
public class CreditLimitServiceImpl implements CreditLimitService {

	@Autowired private CreditLimitRepository creditLimitRepo;
	
	@Override
	public CreditLimit getCreditLimitById(ObjectId creditLimitId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(CreditLimit creditLimit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditLimit> saveAll(List<CreditLimit> creditLimits) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CreditLimit creditLimit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId creditLimitId) throws Exception {
		try {
			creditLimitRepo.deleteById(creditLimitId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
