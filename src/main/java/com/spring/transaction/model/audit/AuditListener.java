package com.spring.transaction.model.audit;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Customized version of the JPA auditing feature, which responds to entity changes by setting audit fields. See
 * {@link http://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-auditing-part-one/}
 * and
 * {@link http://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-auditing-part-two/}.
 * We're using a customized version because our audit fields are embedded via composition using
 * {@link AuditData} rather than in-lined via inheritance.
 * 
 * @author venkataudaykiranp
 *
 */
public class AuditListener {
	
	// TODO Set up @Configurable, and then inject both the AuditingTimestampProvider and the AuditingUsernameProvider
	// instead of creating internal instances on a per-save basis. See
	// http://stackoverflow.com/questions/31205852/configurable-beans-not-working-with-jpa-entitylisteners-in-spring-boot
	// [WLW]
	private AuditingTimestampProvider timestampProvider = new AuditingTimestampProvider();
	private AuditingUsernameProvider usernameProvider = new AuditingUsernameProvider();
	
	@PrePersist
	public void onPrePersist(Object o) {
		updateAuditFields(o);
	}

	@PreUpdate
	public void onPreUpdate(Object o) {
		updateAuditFields(o);
	}

	private void updateAuditFields(Object o) {
		if (o instanceof Auditable) {
			Auditable auditable = (Auditable) o;
			AuditData auditData = getAuditDataCreatingIfAbsent(auditable);
			//Date timestamp = LocalDateTime.from(timestampProvider.getNow().get());
			
			ZonedDateTime zdt = LocalDateTime.from(timestampProvider.getNow().get()).atZone(ZoneId.systemDefault());
			Date timestamp = Date.from(zdt.toInstant());
			
			String username = usernameProvider.getCurrentAuditor().orElse(null);
			
			if (auditData.getCreateDate() == null) {
				auditData.setCreateDate(timestamp);
				auditData.setCreateName(username);
			}
			
			auditData.setUpdateDate(timestamp);
			auditData.setUpdateName(username);
		}
	}
	
	private AuditData getAuditDataCreatingIfAbsent(Auditable auditable) {
		AuditData auditData = auditable.getAuditData();
		if (auditData == null) {
			auditData = new AuditData();
			auditable.setAuditData(auditData);			
		}		
		return auditData;
	}
}