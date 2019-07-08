package com.spring.transaction.model.audit;

/**
 * Interface to mark an entity as auditable. This allows {@link AuditListener} to get and set audit
 * data.
 * 
 * @author venkataudaykiranp
 *
 */
public interface Auditable {

	AuditData getAuditData();

	void setAuditData(AuditData auditData);
}