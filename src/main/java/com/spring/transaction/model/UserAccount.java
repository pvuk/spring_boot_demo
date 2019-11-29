package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "USER_ACCOUNT")
public class UserAccount {
	
	@Field(value = "USER_ACCOUNT_ID")
	@Id
	private String userAccountId;
	
	@Field(value = "USER_STATUS_ID")
	private String userStatusId;
	
	@Field(value = "ACTIVATED_ON")
	private Date activatedOn;
	
	/**
	 * 1. Last login into site
	 * 2. Display on UI as 'DD-MMM-YYYY HH:mm' format 
	 */
	@Field(value = "LAST_ACCESSED_DATE")
	private Date lastAccessedDate;
	
	/**
	 * 1. This value should be updated only when day changes.
	 * 2. Use Threading / @Async call of spring concept todo update once the day changes.
	 * 3. Don't update if no transactions found
	 * 4. Send weekly / monthly / yearly notification, if no transaction found.
	 */
	@Field(value = "LAST_TRANSFERRED_ON")
	private Date lastTransferredOn;
	
	/**
	 * 1. account CLOSED_ON
	 */
	@Field(value = "CLOSED_ON")
	private Date closedOn;
	
	/**
	 * 1. Only record should be active per BANK_ID
	 */
	@Field(value = "IS_ACTIVE")
	private Boolean isActive;
	
	/**
	 * <ol>Following options should not be accessible if user doing Miscellaneous activity.
	 * 	<li>ACCESSIBLE_NEW_OPTION</li>
	 * 	<li>ACCESSIBLE_FROM</li>
	 * 	<li>ACCESSIBLE_COMMENT</li>
	 * 	<li>ACCESSIBLE_REJECTED_ON</li>
	 * 	<li>ACCESSIBLE_REJECTED_COMMENT</li>
	 * </ol>
	 *  
	 */
	@Field(value = "ACCESSIBLE_NEW_OPTION")				private Boolean accessibleNewOption;
	@Field(value = "ACCESSIBLE_FROM")					private Date accessibleFrom;
	@Field(value = "ACCESSIBLE_COMMENT")				private String accessibleComment;
	@Field(value = "ACCESSIBLE_REJECTED_ON")			private Date accessibleRejectedOn;
	/**
	 * 1. If user do Miscellaneous entries to OPTION_NAME(document NEW_OPTION_REQUEST) then ACCESSIBLE_NEW_OPTION is 'N'.
	 */
	@Field(value = "ACCESSIBLE_REJECTED_COMMENT")		private String accessibleRejectedComment;
	
	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")	private String customerId;
}
