package com.spring.transaction.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.transaction.model.Bank;

//No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface BankMongoRepository extends MongoRepository<Bank, Long>{

	Bank findByBankName(String bankName);
}
