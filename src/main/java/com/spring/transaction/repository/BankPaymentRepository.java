package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.BankPayment;

@RepositoryRestResource(collectionResourceRel = "bankPayment", path = "bankPayment")
public interface BankPaymentRepository extends MongoRepository<BankPayment, ObjectId> {
	
}
