package com.spring.transaction.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PROFESSION")
public class Profession {

	private String professionId;
	
	private String code;
	
	private Long position;
	
	private String description;
	
	private boolean isNew;
	
	private boolean isApproved;
	
	/**
	 * 1. insert customer_id
	 */
	private String approvedBy;
	
	private Date approvedOn;
}
