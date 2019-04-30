package com.spring.transaction.service;

import com.spring.transaction.model.CardType;

public interface CardTypeService {
	
	public CardType save(CardType cardType);
	
	public CardType update(CardType cardType);
	
	public String delete(CardType cardType);
	
	public CardType getCardTypeById(String cardTypeId);
}
