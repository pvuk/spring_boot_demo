package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.model.Address;
import com.spring.transaction.repository.AddressRepository;
import com.spring.transaction.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

	@Autowired private AddressRepository  addressRepo;
	
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
	public String deleteById(ObjectId addressId) throws Exception {
		try {
			Optional<Address> findById = addressRepo.findById(addressId);
			if (findById.isPresent()) {
				//implement to delete child table data of permanentAddress and currentAddress
				addressRepo.deleteById(addressId);
			} else {
				throw new NotFoundException("AddressId: "+ addressId +" not found.");
			}
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

}
