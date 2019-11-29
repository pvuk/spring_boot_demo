package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * There should be 3 status only. They are Active, InActive, Hold.
 * 
 * @author venkataudaykiranp
 * @Date Fri 29-Nov-2019 20:15
 */
@Data
@Document(collection = "USER_STATUS_CODE")
public class UserStatus {
	
	@Field(value = "USER_STATUS_ID")
	@Id
	private String userStatusId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "User Status Code is required field.")
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "User Status is required field.")
	private String description;
}
