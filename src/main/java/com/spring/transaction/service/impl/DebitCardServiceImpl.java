package com.spring.transaction.service.impl;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.repository.DebitCardRepository;
import com.spring.transaction.service.DebitCardService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class DebitCardServiceImpl implements DebitCardService {

	@Autowired DebitCardRepository debitCardRepo;
	
	@Override
	public DebitCard saveDebitCard(DebitCard debitCard) {
		
		return debitCard;
	}

	@Override
	public DebitCard updateDebitCard(DebitCard debitCard) {
		
		return debitCard;
	}

	@Override
	public DebitCard getByDebitCardId(ObjectId debitCardId) {
		Optional<DebitCard> byId = debitCardRepo.findById(debitCardId);
		return byId.isPresent() ? byId.get() : null;
	}

}
