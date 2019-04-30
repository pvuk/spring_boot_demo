package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.DebitCardPayment;

@RepositoryRestResource(collectionResourceRel = "debitCardPayment", path = "debitCardPayment")
public interface DebitCardPaymentRepository extends MongoRepository<DebitCardPayment, ObjectId> {
	
}
