package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentReceived;

@RepositoryRestResource(collectionResourceRel = "paymentReceived", path = "paymentReceived")
public interface PaymentReceivedRepository extends MongoRepository<PaymentReceived, ObjectId> {
	
}
