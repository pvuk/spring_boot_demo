package com.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.pattern.abstraction.EntityBridgeAbstraction;
import com.spring.transaction.pattern.abstraction.impl.EntityBridgeAbstractionImpl;
import com.spring.transaction.pattern.service.impl.EntityBridgeHibernateServiceImplementor;
import com.spring.transaction.pattern.service.impl.EntityBridgeMongoDBServiceImplementor;
import com.spring.transaction.pattern.service.impl.EntityBridgeMySqlServiceImplementor;
import com.spring.transaction.pattern.service.impl.EntityBridgeOracleServiceImplementor;
import com.spring.transaction.pattern.service.impl.EntityBridgePostgresqlServiceImplementor;
import com.spring.transaction.validator.MessageConstants;

/**
 * 
 * @author udaykiran pulipati
 *
 */
@BasePathAwareController
@RequestMapping(value = "/data/custom/")
public class EntityBridgeDataController {

	@Autowired private EntityBridgeAbstraction connect;

	public @ResponseBody Object save(@PathVariable(name = "dbConnect") String dbConnect, @RequestBody Object save) {
		switch (dbConnect) {
		case "MongoDB":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeMongoDBServiceImplementor());
			break;
		case "Postgresql":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgePostgresqlServiceImplementor());
			break;
		case "Hibernate":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeHibernateServiceImplementor());
			break;
		case "MySql":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeMySqlServiceImplementor());
			break;
		case "Oracle":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeOracleServiceImplementor());
			break;
		default:
			throw new NotFoundException("Database notfound. " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
		}
		Object saveData = connect.save(save);
		return saveData;
	}
}
