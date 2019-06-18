package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.PaymentBy;
import com.spring.transaction.repository.PaymentByRepository;
import com.spring.transaction.service.PaymentByService;
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
public class PaymentByServiceImpl implements PaymentByService {

	@Autowired private PaymentByRepository paymentByRepo;
	
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
	public String deleteById(ObjectId paymentById) throws Exception {
		try {
			paymentByRepo.deleteById(paymentById);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
