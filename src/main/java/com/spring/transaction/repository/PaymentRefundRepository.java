package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentRefund;

@RepositoryRestResource(collectionResourceRel = "paymentRefund", path = "paymentRefund")
public interface PaymentRefundRepository extends MongoRepository<PaymentRefund, ObjectId> {
	
}
