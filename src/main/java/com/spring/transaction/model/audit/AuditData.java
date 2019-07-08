package com.spring.transaction.model.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * 
 * Encapsulates audit fields so we can include them by composition rather than by inheritance. This makes it easier to
 * deal with entities that don't have audit fields.
 * 
 * @author venkataudaykiranp
 *
 */
@Data
@Embeddable
@JsonIgnoreProperties(ignoreUnknown=true)
public class AuditData implements Serializable {
	
	// Removed @Type below as we don't need that for standard java.util.Date. [WLW]
	// Removed @CreatedDate, @LastModifiedDate, etc., as we're using a custom TuscanyAuditingEntityListener that already
	// knows what the audit fields are. Those annotations are for the generic JPA AuditingEntityListener. [WLW]
	
    @Column(name = "create_date")
    private Date createDate;
 
    @Column(name = "update_date")
    private Date updateDate;
    
    @Column(name = "create_name")
	private String createName;
    
    @Column(name = "update_name")
	private String updateName;    
}