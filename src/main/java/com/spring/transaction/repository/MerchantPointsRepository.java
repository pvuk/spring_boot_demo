package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.MerchantPoints;

@RepositoryRestResource(collectionResourceRel = "merchantPoints", path = "merchantPoints")
public interface MerchantPointsRepository extends MongoRepository<MerchantPoints, ObjectId> {
	
}
