package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.DebitCard;

public interface DebitCardService {
	
	DebitCard getDebitCardById(ObjectId debitCardId) throws Exception;
	
	String save(DebitCard debitCard) throws Exception;
	
	List<DebitCard> saveAll(List<DebitCard> debitCards) throws Exception;
	
	String update(DebitCard debitCard) throws Exception;
	
	String deleteDebitCardById(ObjectId debitCardId) throws Exception;
	
}
