package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CreditLimit;
import com.spring.transaction.service.CreditLimitService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CreditLimitServiceImpl implements CreditLimitService {

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
	public String deleteCreditLimitById(ObjectId creditLimitId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
