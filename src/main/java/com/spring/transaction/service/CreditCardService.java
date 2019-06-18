package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CreditCard;

public interface CreditCardService {

	CreditCard getCreditCardById(ObjectId creditCardId) throws Exception;
	
	String save(CreditCard creditCard) throws Exception;
	
	List<CreditCard> saveAll(List<CreditCard> creditCards) throws Exception;
	
	String update(CreditCard creditCard) throws Exception;
	
	String deleteById(ObjectId creditCardId) throws Exception;
}
