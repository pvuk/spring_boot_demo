package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CardPayment;

@RepositoryRestResource(collectionResourceRel = "cardPayment", path = "cardPayment")
public interface CardPaymentRepository extends MongoRepository<CardPayment, ObjectId> {
	
}
