package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="CHECK_BOOK")
public class CheckBook {
	
	@Field(value = "CHECK_BOOK_ID")
	@Id
	private String checkBookId;
	
	private String bankBranchId;
	
	private BigDecimal amount;
	
	private Integer totalNoOfLeaves;
	
	private Integer availableLeaves;
	
	private String payeeName;
	
	private String depositCheckAtBranch;
	
	private Date depositCheckOn;
	
	private String dropCheckAtBranch;
	
	private Date dropCheckOn;
	
	private BigDecimal checkNumber;
	
	private Date signOn;
	
	private Date validUpto;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
