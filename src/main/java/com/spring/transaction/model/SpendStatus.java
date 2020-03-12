package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p>
 * 	<ol>
 * 		<li>When CODE = participate send the remainder to CUSTOMER_ID to complete the offer.</li>
 * 		<li>When SPEND_STATUS_CODE is completed then CLAIM_STATUS_CODE should be updated to Active automatically.
 * </ol>
 * </p>
 * 
 * @author venkataudaykiranp
 * @Date Wed 11-Mar-2020 10:37
 * 
 * @version 2.0
 */
@Data
@Document(collection = "SPEND_STATUS_CODE")
public class SpendStatus {
	
	@Id
	@Field(value = "SPEND_STATUS_ID")					private String spendStatusId;
	
	@Field(value="CODE")
	@Indexed(unique=true)								private String code;
	
	@Field(value="POSITION") 							private Long position;
	
	@NotNull(message="Spend Status is required field.")
	@Field(value="DESCRIPTION") 						private String description;
	
	@Field(value="DETAILS") 							private String details;
}
