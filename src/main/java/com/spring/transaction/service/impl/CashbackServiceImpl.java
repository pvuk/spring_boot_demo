package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.Cashback;
import com.spring.transaction.repository.CashbackRepository;
import com.spring.transaction.service.CashbackService;
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
public class CashbackServiceImpl implements CashbackService {

	@Autowired private CashbackRepository cashbackRepo;
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
	public String deleteById(ObjectId cashbackId) throws Exception {
		try {
			cashbackRepo.deleteById(cashbackId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}
	
}
