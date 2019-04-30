package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentReverse;

@RepositoryRestResource(collectionResourceRel = "paymentReverse", path = "paymentReverse")
public interface PaymentReverseRepository extends MongoRepository<PaymentReverse, ObjectId> {

}
