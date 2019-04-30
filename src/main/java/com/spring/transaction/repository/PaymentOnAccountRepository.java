package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.PaymentOnAccount;

@RepositoryRestResource(collectionResourceRel = "paymentOnAccount", path = "paymentOnAccount")
public interface PaymentOnAccountRepository extends MongoRepository<PaymentOnAccount, ObjectId> {

}
