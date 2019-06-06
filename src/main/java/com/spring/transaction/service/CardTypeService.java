package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CardType;

public interface CardTypeService {
	
	CardType getCardTypeById(ObjectId cardTypeId) throws Exception;
	
	String save(CardType cardType) throws Exception;
	
	List<CardType> saveAll(List<CardType> cardTypes) throws Exception;
	
	String update(CardType cardType) throws Exception;
	
	String delete(ObjectId cardTypeId) throws Exception;
}
