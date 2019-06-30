package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.service.CRUDOperationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CRUDOperationsServiceImpl implements CRUDOperationService {
	
	@Override
	public String save(Object insert) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> saveAll(List<Object> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

}
