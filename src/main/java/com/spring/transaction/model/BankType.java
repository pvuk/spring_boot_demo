package com.spring.transaction.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	@Field(value = "BANK_TYPE_ID", order = 2)
	private String id;
	
	@Indexed(unique = true)
	@NotBlank(message = "Bank Type Code is required field.")
	private String code;
	private int position;
	
	@NotEmpty(message = "Bank Type is required field")
	private String description;
}
