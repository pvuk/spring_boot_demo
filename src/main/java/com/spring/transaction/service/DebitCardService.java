package com.spring.transaction.service;

import com.spring.transaction.model.DebitCard;

public interface DebitCardService {
	
	DebitCard saveDebitCard(DebitCard debitCard);
	
	DebitCard updateDebitCard(DebitCard debitCard);
	
	DebitCard findByDebitCardId(long debitCardId);
	
}
