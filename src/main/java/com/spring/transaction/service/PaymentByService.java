package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.PaymentBy;

public interface PaymentByService {
	
	PaymentBy getPaymentByById(ObjectId paymentById) throws Exception;
	
	String save(PaymentBy paymentBy) throws Exception;
	
	List<PaymentBy> saveAll(List<PaymentBy> paymentBys) throws Exception;
	
	String update(PaymentBy paymentBy) throws Exception;
	
	String deletePaymentByById(ObjectId paymentById) throws Exception;
}
