package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CreditLimit;

public interface CreditLimitService {

	CreditLimit getCreditLimitById(ObjectId creditLimitId) throws Exception;
	
	String save(CreditLimit creditLimit) throws Exception;
	
	List<CreditLimit> saveAll(List<CreditLimit> creditLimits) throws Exception;
	
	String update(CreditLimit creditLimit) throws Exception;
	
	String deleteCreditLimitById(ObjectId creditLimitId) throws Exception;
}
