package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.NetBankingPayment;

@RepositoryRestResource(collectionResourceRel = "netBankingPayment", path = "netBankingPayment")
public interface NetBankingPaymentRepository extends MongoRepository<NetBankingPayment, ObjectId> {
	
}
