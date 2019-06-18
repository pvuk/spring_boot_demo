package com.spring.transaction.test.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.test.model.Wallet;

@RepositoryRestResource(collectionResourceRel = "wallet", path = "wallet")
public interface WalletRepository extends MongoRepository<Wallet, ObjectId> {
	
}
