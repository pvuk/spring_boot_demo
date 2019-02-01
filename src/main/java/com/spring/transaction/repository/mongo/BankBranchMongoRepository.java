package com.spring.transaction.repository.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.BankBranch;

@RepositoryRestResource(collectionResourceRel="bankbranch", path="bankbranch")
public interface BankBranchMongoRepository extends MongoRepository<BankBranch, ObjectId> {

}
