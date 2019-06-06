package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.MerchantDetails;
import com.spring.transaction.service.MerchantDetailsService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class MerchantDetailsServiceImpl implements MerchantDetailsService {

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
	public String deleteMerchantDetailsById(ObjectId merchantDetailsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
