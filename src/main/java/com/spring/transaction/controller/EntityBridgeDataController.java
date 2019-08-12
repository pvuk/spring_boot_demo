package com.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.exception.NotFoundException;
import com.spring.transaction.pattern.EntityBridgeAbstraction;
import com.spring.transaction.pattern.EntityBridgeAbstractionImpl;
import com.spring.transaction.pattern.EntityBridgeHibernateImplementor;
import com.spring.transaction.pattern.EntityBridgeMongoDBImplementor;
import com.spring.transaction.pattern.EntityBridgeMySqlImplementor;
import com.spring.transaction.pattern.EntityBridgeOracleImplementor;
import com.spring.transaction.pattern.EntityBridgePostgresqlImplementor;
import com.spring.transaction.validator.MessageConstants;

/**
 * 
 * @author udaykiran pulipati
 *
 */
@BasePathAwareController
@RequestMapping(value = "/data/custom/")
public class EntityBridgeDataController {

	@Autowired
	EntityBridgeAbstraction connect;

	public @ResponseBody Object save(@PathVariable(name = "dbConnect") String dbConnect, @RequestBody Object save) {
		switch (dbConnect) {
		case "MongoDB":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeMongoDBImplementor());
			break;
		case "Postgresql":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgePostgresqlImplementor());
			break;
		case "Hibernate":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeHibernateImplementor());
			break;
		case "MySql":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeMySqlImplementor());
			break;
		case "Oracle":
			connect = new EntityBridgeAbstractionImpl(new EntityBridgeOracleImplementor());
			break;
		default:
			throw new NotFoundException("Database notfound. " + MessageConstants.PLEASE_CONTACT_TRANS_IT_SUPPORT);
		}
		Object saveData = connect.save(save);
		return saveData;
	}
}
