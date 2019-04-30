package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CreditLimitDetails;

@RepositoryRestResource(collectionResourceRel = "creditLimitDetails", path = "creditLimitDetails")
public interface CreditLimitDetailsRepository extends MongoRepository<CreditLimitDetails, ObjectId> {

}
