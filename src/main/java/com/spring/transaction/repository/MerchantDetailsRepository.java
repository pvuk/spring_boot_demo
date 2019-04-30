package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.MerchantDetails;

@RepositoryRestResource(collectionResourceRel = "merchantDetails", path = "merchantDetails")
public interface MerchantDetailsRepository extends MongoRepository<MerchantDetails, ObjectId> {
	
}
