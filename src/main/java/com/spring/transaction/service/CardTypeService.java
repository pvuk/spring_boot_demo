package com.spring.transaction.service;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CardType;

public interface CardTypeService {
	
	public CardType save(CardType cardType);
	
	public CardType update(CardType cardType);
	
	public String delete(CardType cardType);
	
	public CardType getCardTypeById(ObjectId cardTypeId);
}
