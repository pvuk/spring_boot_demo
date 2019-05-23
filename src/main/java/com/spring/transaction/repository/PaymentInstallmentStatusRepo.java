package com.spring.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentInstallmentStatus;

@RepositoryRestResource(collectionResourceRel = "paymentInstallmentStatus", path = "paymentInstallmentStatus")
public interface PaymentInstallmentStatusRepo extends MongoRepository<PaymentInstallmentStatus, String> {

}
