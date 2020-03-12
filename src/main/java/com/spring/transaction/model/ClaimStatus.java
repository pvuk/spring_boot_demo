package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * @author venkataudaykiranp
 * @Date Wed 11-Mar-2020 10:43
 */
@Data
@Document(collection = "CLAIM_STATUS_CODE")
public class ClaimStatus {

	@Id
	@Field(value = "CLAIM_STATUS_ID")					private String claimStatusId;
	
	@Field(value="CODE")
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Claim Status is required field.")
	@Field(value="DESCRIPTION") 						private String description;
	
	@Field(value="DETAILS") 							private String details;
}
