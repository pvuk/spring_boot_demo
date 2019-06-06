package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.DebitCard;
import com.spring.transaction.repository.DebitCardRepository;
import com.spring.transaction.service.DebitCardService;
import com.spring.transaction.validator.MessageConstants;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class DebitCardServiceImpl implements DebitCardService {

	@Autowired DebitCardRepository debitCardRepo;
	
	@Override
	public String save(DebitCard debitCard) {
		
		return MessageConstants.WORKING_IN_PROGRESS;
	}
	
	@Override
	public List<DebitCard> saveAll(List<DebitCard> debitCards) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(DebitCard debitCard) {
		
		return MessageConstants.WORKING_IN_PROGRESS;
	}

	@Override
	public String deleteDebitCardById(ObjectId debitCardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitCard getDebitCardById(ObjectId debitCardId) {
		Optional<DebitCard> byId = debitCardRepo.findById(debitCardId);
		return byId.isPresent() ? byId.get() : null;
	}
}
