package com.spring.transaction.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.service.DebitCardService;

@Transactional(rollbackFor = Throwable.class)
public class DebitCardServiceImpl implements DebitCardService {

	@Override
	public DebitCard saveDebitCard(DebitCard debitCard) {
		// TODO Auto-generated method stub
		return debitCard;
	}

	@Override
	public DebitCard updateDebitCard(DebitCard debitCard) {
		// TODO Auto-generated method stub
		return debitCard;
	}

}
