package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.CashbackCategory;

@RepositoryRestResource(collectionResourceRel = "cashbackCategory", path = "cashbackCategory")
public interface CashbackCategoryRepository extends MongoRepository<CashbackCategory, ObjectId> {

}
