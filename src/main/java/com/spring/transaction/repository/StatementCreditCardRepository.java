package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.StatementCreditCard;

@RepositoryRestResource(collectionResourceRel = "statementCreditCard", path = "statementCreditCard")
public interface StatementCreditCardRepository extends MongoRepository<StatementCreditCard, ObjectId> {
	
}
