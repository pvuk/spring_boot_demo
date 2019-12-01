package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author P V UdayKiran
 *
 * @Date: Sun 01-Dec-2019 15:04
 */
@Data
@Document(collection = "BANK_STATUS_CODE")
public class BankStatus {
	
	@Field(value = "BANK_STATUS_ID")
	@Id
	private String bankStatusId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Bank Status Code is required field.")
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "Bank Status is required field.")
	private String description;
}
