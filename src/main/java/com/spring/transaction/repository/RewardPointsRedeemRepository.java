package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.RewardPointsRedeem;

@RepositoryRestResource(collectionResourceRel = "rewardPointsRedeem", path = "rewardPointsRedeem")
public interface RewardPointsRedeemRepository extends MongoRepository<RewardPointsRedeem, ObjectId> {

}
