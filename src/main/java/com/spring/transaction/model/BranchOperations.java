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
	
	@Id
	@Field(value = "BRANCH_OPERATIONS_ID")												private String branchOperationsId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Bank Operations Code is required field.")
	@Field(value = "CODE", order = 2)													private String code;
	
	@Field(value = "POSITION", order = 3)												private int position;
	
	@NotNull(message = "Bank Operations is required field.")
	@Field(value = "DESCRIPTION", order = 4)											private String description;
}
