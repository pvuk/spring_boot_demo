package com.spring.transaction.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CreditCard;
import com.spring.transaction.repository.CreditCardRepository;
import com.spring.transaction.service.CreditCardService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired private CreditCardRepository creditCardRepo;
	
	@Override
	public CreditCard getCreditCardById(ObjectId creditCardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(CreditCard creditCard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditCard> saveAll(List<CreditCard> creditCards) throws Exception {
//		List<CreditCard> list = creditCardRepo.saveAll(creditCards);
		creditCards.stream()
		.filter(cc -> {
			CreditCard code = creditCardRepo.findByCode(cc.getCode());
			if(code != null) {
				cc.getErrorMessageMap().putErrorMsg(cc.getCode(), cc.getDescription() +" Record already exist.");
				return true;
			} else {
				cc = creditCardRepo.save(cc);
			}
			return false;
		})
			.collect(Collectors.toList())
			;
		return creditCards;
	}

	@Override
	public String update(CreditCard creditCard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId creditCardId) throws Exception {
		try {
			creditCardRepo.deleteById(creditCardId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
