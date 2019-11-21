package com.spring.transaction.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.Bank;

@RepositoryRestResource(collectionResourceRel = "bank", path = "bank")
//No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface BankRepository extends MongoRepository<Bank, ObjectId> {

//	List<Bank> findAll();

	Bank findByBankName(@Param(value = "bankName") String bankName);

	List<Bank> findByBankTypeId(@Param(value = "bankTypeId") String bankTypeId);

}
