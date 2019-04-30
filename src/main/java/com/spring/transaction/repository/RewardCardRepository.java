package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.RewardCard;

@RepositoryRestResource(collectionResourceRel = "rewardCard", path = "rewardCard")
public interface RewardCardRepository extends MongoRepository<RewardCard, ObjectId> {
	
}
