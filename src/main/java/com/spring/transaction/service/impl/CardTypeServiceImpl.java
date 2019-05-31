package com.spring.transaction.service.impl;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CardType;
import com.spring.transaction.repository.CardTypeRepository;
import com.spring.transaction.service.CardTypeService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CardTypeServiceImpl implements CardTypeService {

	@Autowired private CardTypeRepository cardTypeRepo;
	
	@Override
	public CardType save(CardType cardType) {
		cardType = cardTypeRepo.insert(cardType);
		return cardType;
	}

	@Override
	public CardType update(CardType cardType) {
		cardType = cardTypeRepo.save(cardType);
		return cardType;
	}

	@Override
	public String delete(CardType cardType) {
		try {
			cardTypeRepo.delete(cardType);
		} catch (Exception e) {
			// maintain error log for catch block using spring aop
			log.error("Record delete failed for cardTypeId: {}, cause: {}", cardType.getCardTypeId(), e.getMessage());
			return MessageConstants.Failed.DELETE + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT;
		}
		return MessageConstants.Success.DELETE;
	}

	@Override
	public CardType getCardTypeById(ObjectId cardTypeId) {
		Optional<CardType> byId = cardTypeRepo.findById(cardTypeId);
		return byId.isPresent() ? byId.get() : null;
	}

}
