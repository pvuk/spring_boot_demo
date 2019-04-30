package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PermanentAddress;

@RepositoryRestResource(collectionResourceRel = "permanentAddress", path = "permanentAddress")
public interface PermanentAddressRepository extends MongoRepository<PermanentAddress, ObjectId> {

}
