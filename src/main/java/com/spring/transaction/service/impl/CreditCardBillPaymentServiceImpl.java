package com.spring.transaction.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.spring.transaction.model.CreditCardBillPayment;
import com.spring.transaction.service.CreditCardBillPaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @Date Thu 27-Feb-2020 17:59
 */
@Service
@Slf4j
public class CreditCardBillPaymentServiceImpl implements CreditCardBillPaymentService {

	@Override
	public CreditCardBillPayment getById(ObjectId getById) throws Exception {
		try {
			
		} catch (Exception e) {
			log.error("getById: {}", e.getMessage());
		}
		return null;
	}

	@Override
	public String save(CreditCardBillPayment save) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CreditCardBillPayment update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId deleteById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
