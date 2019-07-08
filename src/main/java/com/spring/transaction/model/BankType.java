package com.spring.transaction.model;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_TYPE_CODE")
public class BankType {
	
	/*
	 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo-template.id-handling
	 * MongoDB supports autogenerate java types String or BigInteger.
	 * 
	 * If possible, an id property or field declared as a String in the Java class is converted to and stored as an ObjectId by using a Spring Converter<String, ObjectId>. 
	 */
	@Id
	@Field(value = "BANK_TYPE_ID", order = 1)
	private String id;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotEmpty(message = "Bank Type Code is required field.")
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotEmpty(message = "Bank Type is required field.")
	private String description;
	
	@Field(value = "SECTION", order = 5)
	private String section;
	
	@Field(value = "CATEGORY", order = 6)
	private String category;
	
	@Field(value = "COMMENT", order = 7)
	private String comment;
	
	/*
	 * if not found user can add. Need to approve by Admin
	 */
	@Field(value = "IS_NEW", order = 8) 		private Boolean isNew;
	@Field(value = "APPROVED", order = 9) 		private Boolean approved;
	@Field(value = "APPROVED_BY", order = 10) 	private Boolean approvedBy;
	@Field(value = "REJECTED", order = 11) 		private Boolean rejected;
	@Field(value = "REJECTED_BY", order = 12) 	private Boolean rejectedBy;
	
	@Embedded
	private AuditData auditData;
	
	@Transient
	private ErrorMessageMap errorMessageMap;

	@Override
	public String toString() {
		return "BankType [id=" + id + ", code=" + code + ", position=" + position + ", description=" + description
				+ ", section=" + section + ", category=" + category + ", comment=" + comment + ", errorMessageMap="
				+ errorMessageMap + "]";
	}
	
}
