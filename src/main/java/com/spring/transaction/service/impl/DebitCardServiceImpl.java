package com.spring.transaction.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.service.DebitCardService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class DebitCardServiceImpl implements DebitCardService {

	@Override
	public DebitCard saveDebitCard(DebitCard debitCard) {
		
		return debitCard;
	}

	@Override
	public DebitCard updateDebitCard(DebitCard debitCard) {
		
		return debitCard;
	}

	@Override
	public DebitCard findByDebitCardId(long debitCardId) {
		
		return null;
	}

}
