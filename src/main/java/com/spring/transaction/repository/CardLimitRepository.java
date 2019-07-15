package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CardLimit;

@RepositoryRestResource(collectionResourceRel = "cardLimit", path = "cardLimit")
public interface CardLimitRepository extends MongoRepository<CardLimit, ObjectId> {

}
