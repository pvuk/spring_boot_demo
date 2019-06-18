package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.RewardCard;
import com.spring.transaction.repository.RewardCardRepository;
import com.spring.transaction.service.RewardCardService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
@Slf4j
public class RewardCardServiceImpl implements RewardCardService {

	@Autowired private RewardCardRepository rewardCardRepo;
	
	@Override
	public RewardCard getRewardCardById(ObjectId rewardCardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(RewardCard RewardCard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RewardCard> saveAll(List<RewardCard> RewardCards) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(RewardCard RewardCard) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId rewardCardId) throws Exception {
		try {
			rewardCardRepo.deleteById(rewardCardId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
