package com.spring.transaction.repository.mongo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.Bank;

@RepositoryRestResource(collectionResourceRel="bank", path="bank")
//No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface BankMongoRepository extends MongoRepository<Bank, ObjectId>{

	List<Bank> findAllByBankName(@Param(value = "bankName") String bankName);

}
