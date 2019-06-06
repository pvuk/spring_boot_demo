package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.Address;

public interface AddressService {

	Address getAddressById(ObjectId addressId) throws Exception;
	
	String save(Address address) throws Exception;
	
	List<Address> saveAll(List<Address> addresss) throws Exception;
	
	String update(Address address) throws Exception;
	
	String deleteAddressById(ObjectId addressId) throws Exception;
}
