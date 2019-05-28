package com.spring.transaction.service;

import org.bson.types.ObjectId;

import com.spring.transaction.model.DebitCard;

public interface DebitCardService {
	
	DebitCard saveDebitCard(DebitCard debitCard);
	
	DebitCard updateDebitCard(DebitCard debitCard);
	
	DebitCard getByDebitCardId(ObjectId debitCardId);
	
}
