package com.spring.transaction.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.MovieOffer;

@RepositoryRestResource(collectionResourceRel = "movieOffer", path = "movieOffer")
public interface MovieOfferRepository extends MongoRepository<MovieOffer, ObjectId> {
	
}
