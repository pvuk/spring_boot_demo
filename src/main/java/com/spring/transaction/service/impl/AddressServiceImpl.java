package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.Address;
import com.spring.transaction.service.AddressService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AddressServiceImpl implements AddressService {

	@Override
	public Address getAddressById(ObjectId addressId) throws Exception {
		return null;
	}

	@Override
	public String save(Address address) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> saveAll(List<Address> addresss) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Address address) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddressById(ObjectId addressId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
