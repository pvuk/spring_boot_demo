package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CurrentAddress;

@RepositoryRestResource(collectionResourceRel = "currentAddress", path = "currentAddress")
public interface CurrentAddressRepository extends MongoRepository<CurrentAddress, ObjectId> {

}
