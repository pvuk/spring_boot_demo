package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * When we check our bank account statements either Online of printed on
 * Passbook, we see all the transactions with transaction details or remarks.
 * These bank account transaction remarks or transaction details are printed
 * starting with an abbreviation or Legend.
 * 
 * For Example
 * 
 * BIL/0022222222/abcd
 * 
 * In above example BIL is an abbreviation or Legend for "Internet Bill payment
 * or funds transfer to Third party".
 * 
 * @author venkataudaykiranp
 *
 */
@Data
@Document(collection = "LEGEND_CODE")
public class Legend {

	@Id
	@Field(value = "LEGEND_ID", order = 1)
	private String legendId;
	
	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private Long position;
	
	@NotNull(message = "Legend is required field.")
	@Field(value="DESCRIPTION", order = 4)
	private String description;
	
	@Field(value="DETAILS", order = 5)
	private String details;
}
