package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.WalletPayment;

@RepositoryRestResource(collectionResourceRel = "walletPayment", path = "walletPayment")
public interface WalletPaymentRepository extends MongoRepository<WalletPayment, ObjectId> {
	
}
