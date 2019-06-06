package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.Cashback;
import com.spring.transaction.service.CashbackService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CashbackServiceImpl implements CashbackService {

	@Override
	public Cashback getCashbackById(ObjectId cashbackId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Cashback cashback) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cashback> saveAll(List<Cashback> cashbacks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Cashback cashback) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCashbackById(ObjectId cashbackId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
