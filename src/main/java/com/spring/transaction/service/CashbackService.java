package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.Cashback;

public interface CashbackService {
	
	Cashback getCashbackById(ObjectId cashbackId) throws Exception;
	
	String save(Cashback cashback) throws Exception;
	
	List<Cashback> saveAll(List<Cashback> cashbacks) throws Exception;
	
	String update(Cashback cashback) throws Exception;
	
	String deleteById(ObjectId cashbackId) throws Exception;
}
