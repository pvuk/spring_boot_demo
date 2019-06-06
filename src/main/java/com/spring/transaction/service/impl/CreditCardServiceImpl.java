package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.CreditCard;
import com.spring.transaction.service.CreditCardService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CreditCardServiceImpl implements CreditCardService {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CreditCard creditCard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCreditCardById(ObjectId creditCardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
