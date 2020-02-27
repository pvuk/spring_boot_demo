package com.spring.transaction.service;

import org.bson.types.ObjectId;

import com.spring.transaction.model.CreditCardBillPayment;

/**
 * 
 * @author venkataudaykiranp
 * @Date Thu 27-Feb-2020 18:00
 */
public interface CreditCardBillPaymentService {

	CreditCardBillPayment getById(ObjectId getById) throws Exception;

	String save(CreditCardBillPayment save) throws Exception;

	String update(CreditCardBillPayment update) throws Exception;

	String deleteById(ObjectId deleteById) throws Exception;
}
