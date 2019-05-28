package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankType;

public interface BankTypeService {
	
	String save(BankType bankType) throws Exception;
	
	List<BankType> saveAll(List<BankType> bankTypes) throws Exception;
	
	String update(BankType bankType) throws Exception;
	
	String deleteBankTypeById(ObjectId bankTypeId);
}
