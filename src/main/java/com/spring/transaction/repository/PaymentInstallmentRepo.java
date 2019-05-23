package com.spring.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentInstallment;

@RepositoryRestResource(collectionResourceRel = "paymentInstallment", path = "paymentInstallment")
public interface PaymentInstallmentRepo extends MongoRepository<PaymentInstallment, String>{

}
