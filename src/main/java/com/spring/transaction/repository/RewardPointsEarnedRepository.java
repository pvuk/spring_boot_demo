package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.RewardPointsEarned;

@RepositoryRestResource(collectionResourceRel = "rewardPointsEarned", path = "rewardPointsEarned")
public interface RewardPointsEarnedRepository extends MongoRepository<RewardPointsEarned, ObjectId> {
	
}
