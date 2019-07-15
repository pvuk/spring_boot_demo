package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CardLimit;

public interface CardLimitService {

	CardLimit getCreditLimitById(ObjectId cardLimitId) throws Exception;
	
	String save(CardLimit creditLimit) throws Exception;
	
	List<CardLimit> saveAll(List<CardLimit> list) throws Exception;
	
	String update(CardLimit cardLimit) throws Exception;
	
	String deleteById(ObjectId cardLimitId) throws Exception;
}
