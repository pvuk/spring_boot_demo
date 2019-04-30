package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditCardPayment;

@RepositoryRestResource(collectionResourceRel = "creditCardPayment", path = "creditCardPayment")
public interface CreditCardPaymentRepository extends MongoRepository<CreditCardPayment, ObjectId> {
	
}
