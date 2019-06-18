package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.MerchantDetails;

public interface MerchantDetailsService {
	
	MerchantDetails getMerchantDetailsById(ObjectId merchantDetailsId) throws Exception;
	
	String save(MerchantDetails merchantDetails) throws Exception;
	
	List<MerchantDetails> saveAll(List<MerchantDetails> merchantDetailss) throws Exception;
	
	String update(MerchantDetails merchantDetails) throws Exception;
	
	String deleteById(ObjectId merchantDetailsId) throws Exception;
}
