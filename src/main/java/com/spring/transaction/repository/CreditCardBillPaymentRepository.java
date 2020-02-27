package com.spring.transaction.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditCardBillPayment;

@RepositoryRestResource(collectionResourceRel = "creditCardBillPayment", path = "creditCardBillPayment")
public interface CreditCardBillPaymentRepository extends MongoRepository<CreditCardBillPayment, ObjectId> {
	
	List<CreditCardBillPayment> findByCreditCardId(String creditCardId);
	
	CreditCardBillPayment findByCreditCardIdAndcreditCardStatementId(String creditCardId, String creditCardStatementId);
}
