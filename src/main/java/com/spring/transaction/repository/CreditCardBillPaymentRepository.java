package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditCardBillPayment;

@RepositoryRestResource(collectionResourceRel = "creditCardBillPayment", path = "creditCardBillPayment")
public interface CreditCardBillPaymentRepository extends MongoRepository<CreditCardBillPayment, ObjectId> {
	
}
