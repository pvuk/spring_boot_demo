package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.RewardPointsDetails;

@RepositoryRestResource(collectionResourceRel = "rewardPoints", path = "rewardPoints")
public interface RewardPointsRepository extends MongoRepository<RewardPointsDetails, ObjectId> {
	
}
