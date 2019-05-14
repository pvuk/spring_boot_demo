package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentBy;

@RepositoryRestResource(collectionResourceRel = "paymentBy", path = "paymentBy")
public interface PaymentByRepository extends MongoRepository<PaymentBy, ObjectId> {
	
}
