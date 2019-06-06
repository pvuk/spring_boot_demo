package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.RewardCard;

public interface RewardCardService {
	
	RewardCard getRewardCardById(ObjectId rewardCardId) throws Exception;
	
	String save(RewardCard RewardCard) throws Exception;
	
	List<RewardCard> saveAll(List<RewardCard> RewardCards) throws Exception;
	
	String update(RewardCard RewardCard) throws Exception;
	
	String deleteRewardCardById(ObjectId rewardCardId) throws Exception;
}
