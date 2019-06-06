package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.RewardCard;
import com.spring.transaction.service.RewardCardService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class RewardCardServiceImpl implements RewardCardService {

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
	public String deleteRewardCardById(ObjectId rewardCardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
