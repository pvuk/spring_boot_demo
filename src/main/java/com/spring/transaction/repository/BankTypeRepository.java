package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.BankType;

@RepositoryRestResource(collectionResourceRel = "bankType", path = "bankType")
public interface BankTypeRepository extends MongoRepository<BankType, ObjectId> {
	
}
