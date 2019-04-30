package com.spring.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CardType;
import com.spring.transaction.repository.CardTypeRepository;
import com.spring.transaction.service.CardTypeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CardTypeServiceImpl implements CardTypeService {

	@Autowired private CardTypeRepository cardTypeRepo;
	
	@Override
	public CardType save(CardType cardType) {
		cardType = cardTypeRepo.save(cardType);
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
			log.error("Record delete failed for cardTypeId: {}", cardType.getCardTypeId());
			// maintain error log for catch block using spring aop
			log.error("delete: {}", e.getMessage());
			return "Record delete failed";
		}
		return "Record deleted Successfully";
	}

	@Override
	public CardType getCardTypeById(String cardTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
