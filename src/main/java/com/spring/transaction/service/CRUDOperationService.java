package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

public interface CRUDOperationService {

	String save(Object insert) throws Exception;

	List<Object> saveAll(List<Object> list) throws Exception;

	String update(Object update) throws Exception;

	String deleteById(ObjectId id) throws Exception;

	Object getById(ObjectId id);
}
