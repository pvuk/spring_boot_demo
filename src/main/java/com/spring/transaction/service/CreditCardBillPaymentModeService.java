package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankType;
import com.spring.transaction.model.CreditCardBillPaymentMode;

public interface CreditCardBillPaymentModeService {
	
	CreditCardBillPaymentMode getById(ObjectId getById) throws Exception;
	
	String save(CreditCardBillPaymentMode save) throws Exception;
	
	List<BankType> saveAll(List<CreditCardBillPaymentMode> saveList) throws Exception;
	
	String update(CreditCardBillPaymentMode update) throws Exception;
	
	String updateAll(List<CreditCardBillPaymentMode> updateList) throws Exception;
	
	String deleteById(ObjectId deleteById) throws Exception;
}
