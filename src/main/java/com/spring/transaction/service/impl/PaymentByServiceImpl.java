package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.PaymentBy;
import com.spring.transaction.service.PaymentByService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class PaymentByServiceImpl implements PaymentByService {

	@Override
	public PaymentBy getPaymentByById(ObjectId paymentById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(PaymentBy paymentBy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentBy> saveAll(List<PaymentBy> paymentBys) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(PaymentBy paymentBy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePaymentByById(ObjectId paymentById) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
