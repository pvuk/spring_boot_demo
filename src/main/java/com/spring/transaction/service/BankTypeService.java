package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankType;

public interface BankTypeService {
	
	String saveBankType(BankType bankType) throws Exception;
	
	List<BankType> saveAllBankTypes(List<BankType> bankTypes) throws Exception;
	
	String updateBankType(BankType bankType) throws Exception;
	
	String deleteBankTypeById(ObjectId bankTypeId);
}
