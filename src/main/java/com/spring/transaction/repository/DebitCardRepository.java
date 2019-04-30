package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.DebitCard;

@RepositoryRestResource(collectionResourceRel = "debitCard", path = "debitCard")
public interface DebitCardRepository extends MongoRepository<DebitCard, ObjectId> {

}
