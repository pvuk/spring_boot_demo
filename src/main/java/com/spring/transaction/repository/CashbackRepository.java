package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.Cashback;

@RepositoryRestResource(collectionResourceRel = "cashback", path = "cashback")
public interface CashbackRepository extends MongoRepository<Cashback, ObjectId> {
	
}
