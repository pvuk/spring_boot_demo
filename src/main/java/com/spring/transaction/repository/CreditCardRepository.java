package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditCard;

@RepositoryRestResource(collectionResourceRel = "creditCard", path = "creditCard")
public interface CreditCardRepository extends MongoRepository<CreditCard, ObjectId> {
	@Override
	default <S extends CreditCard> S save(S entity) {
		return entity;
	}
}
