package com.spring.transaction.pattern.abstraction.impl;

import org.springframework.stereotype.Service;

import com.spring.transaction.pattern.abstraction.EntityBridgeAbstraction;
import com.spring.transaction.pattern.service.EntityBridgeImplementor;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author udaykiran pulipati
 * 
 * Source: <a href="https://howtodoinjava.com/design-patterns/structural/bridge-design-pattern/">Bridge Design Pattern</a>
 *
 */
@Slf4j
@Service
public class EntityBridgeAbstractionImpl implements EntityBridgeAbstraction {

//	@Autowired
	private EntityBridgeImplementor dbConnect = null;
	
	public EntityBridgeAbstractionImpl(EntityBridgeImplementor dbConnect) {
//		super();
		this.dbConnect = dbConnect;
	}
	
	@Override
	public Object save(Object save) {
		log.info("save: {}", save);
		return dbConnect.saveModel(save);
	}

	@Override
	public Object getById(Object id) {
		
		return dbConnect.getModelById(id);
	}

	@Override
	public Object update(Object update) {
		
		return dbConnect.updateModel(update);
	}

	@Override
	public Object delete(Object delete) {
		
		return dbConnect.deleteModel(delete);
	}

}
