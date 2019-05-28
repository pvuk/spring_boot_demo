package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	@Field(value = "BANK_TYPE_ID")
	private String id;
	
	@Field(value = "CODE")
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotEmpty(message = "Bank Type Code is required field.")
	private String code;
	
	@Field(value = "POSITION")
	private int position;
	
	@Field(value = "DESCRIPTION")
	@NotEmpty(message = "Bank Type is required field.")
	private String description;
	
	@Field(value = "SECTION")
	private String section;
	
	@Field(value = "CATEGORY")
	private String category;
	
	@Field(value = "COMMENT")
	private String comment;
	
	@Transient
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();

	@Override
	public String toString() {
		return "BankType [id=" + id + ", code=" + code + ", position=" + position + ", description=" + description
				+ ", section=" + section + ", category=" + category + ", comment=" + comment + ", errorMessageMap="
				+ errorMessageMap + "]";
	}
	
}
