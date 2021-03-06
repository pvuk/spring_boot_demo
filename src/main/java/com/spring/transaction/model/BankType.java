package com.spring.transaction.model;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

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
	
	/**
	 * 1. <a href="https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo-template.id-handling">10.5.1. How the _id Field is Handled in the Mapping Layer</a></br>
	 * 2. MongoDB supports autogenerate java types String or BigInteger.
	 * 3. If possible, an id property or field declared as a String in the Java class is converted to and stored as an ObjectId by using a Spring Converter<String, ObjectId>. 
	 */
	@Id
	@Field(value = "BANK_TYPE_ID", order = 1)											private String id;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Bank Type Code is required field.")
	@Field(value = "CODE", order = 2)													private String code;
	
	@Field(value = "POSITION", order = 3)												private int position;
	
	@NotNull(message = "Bank Type is required field.")
	@Field(value = "DESCRIPTION", order = 4)											private String description;
	
	@Field(value = "SECTION", order = 5)												private String section;
	
	@Field(value = "CATEGORY", order = 6)												private String category;
	
	@Field(value = "COMMENT", order = 7)												private String comment;
	
	@Embedded
	private AuditData auditData;
	
	@Transient
	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();;

	@Override
	public String toString() {
		return "BankType [id=" + id + ", code=" + code + ", position=" + position + ", description=" + description
				+ ", section=" + section + ", category=" + category + ", comment=" + comment + ", auditData="
				+ auditData + ", errorMessageMap=" + errorMessageMap + "]";
	}
	
}
