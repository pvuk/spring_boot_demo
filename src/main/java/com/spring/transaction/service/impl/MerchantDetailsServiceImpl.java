package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.MerchantDetails;
import com.spring.transaction.repository.MerchantDetailsRepository;
import com.spring.transaction.service.MerchantDetailsService;
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
public class MerchantDetailsServiceImpl implements MerchantDetailsService {

	@Autowired private MerchantDetailsRepository merchantDetailsRepo;
	@Override
	public MerchantDetails getMerchantDetailsById(ObjectId merchantDetailsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(MerchantDetails merchantDetails) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MerchantDetails> saveAll(List<MerchantDetails> merchantDetailss) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(MerchantDetails merchantDetails) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId merchantDetailsId) throws Exception {
		try {
			merchantDetailsRepo.deleteById(merchantDetailsId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
