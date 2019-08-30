package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankType;
import com.spring.transaction.model.CreditCardModeOfPayment;

public interface CreditCardModeOfPaymentService {
	
	CreditCardModeOfPayment getById(ObjectId getById) throws Exception;
	
	String save(CreditCardModeOfPayment save) throws Exception;
	
	List<BankType> saveAll(List<CreditCardModeOfPayment> saveList) throws Exception;
	
	String update(CreditCardModeOfPayment update) throws Exception;
	
	String updateAll(List<CreditCardModeOfPayment> updateList) throws Exception;
	
	String deleteById(ObjectId deleteById) throws Exception;
}
