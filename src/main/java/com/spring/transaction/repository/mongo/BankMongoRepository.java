package com.spring.transaction.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.transaction.model.Bank;

//No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface BankMongoRepository extends MongoRepository<Bank, Long>{

	List<Bank> findAllByBankName(String bankName);
}
