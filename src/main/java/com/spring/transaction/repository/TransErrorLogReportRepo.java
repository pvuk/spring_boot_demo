package com.spring.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.transaction.model.TransErrorLogReport;

@RepositoryRestResource(collectionResourceRel = "transErrorLogReport", path = "transErrorLogReport")
public interface TransErrorLogReportRepo extends CrudRepository<TransErrorLogReport, String> {
	
}
