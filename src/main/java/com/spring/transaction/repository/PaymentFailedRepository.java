package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentFailed;

@RepositoryRestResource(collectionResourceRel = "paymentFailed", path = "paymentFailed")
public interface PaymentFailedRepository extends MongoRepository<PaymentFailed, ObjectId> {
	
}
