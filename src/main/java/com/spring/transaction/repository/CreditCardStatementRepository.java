package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditCardStatement;

@RepositoryRestResource(collectionResourceRel = "creditCardStatement", path = "creditCardStatement")
public interface CreditCardStatementRepository extends MongoRepository<CreditCardStatement, ObjectId> {
	
}
