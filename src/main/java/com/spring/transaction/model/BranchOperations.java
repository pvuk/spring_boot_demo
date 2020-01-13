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
 * <p>Some branches operated all types loans and some are operate only personal loan.<p>
 * 
 * @author venkataudaykiranp
 * @Date Fri 29-Nov-2019 20:43
 */
@Data
@Document(collection = "BRANCH_OPERATIONS_CODE")
public class BranchOperations {
	
	@Field(value = "BRANCH_OPERATIONS_ID")
	@Id
	private String branchOperationsId;
	
	@Field(value = "CODE", order = 2)
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Bank Operations Code is required field.")
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotNull(message = "Bank Operations is required field.")
	private String description;
}
