package com.spring.transaction.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * <p>
 * This class contains preInsert() method if 
 * 1. {@link #no_of_times_login_failed} column value == null it assigns 0 as default value.
 * </p>
 * 
 * @author UdayKiran Pulipati
 *
 */
@Data
@Document(collection="PROFILE_PASSWORD")
public class ProfilePassword {
	
	@Id
	@Field(value="PROFILE_PASSWORD_ID")
	private String profilePasswordId;
	
	@Field(value = "PASSWORD")
	private String password;
	
	@Field(value = "IS_ACTIVE")
	private boolean isActive;
	
	/*
	 * 1. If the user forgot and try after 4 hours / next day before
	 * next_success_login_date don't update loginFailedDate
	 */
	@Field(value="LOGIN_FAILED_DATE")
	private Date loginFailedDate;
	
	/*
	 * 1. Allow the user upto 5 attempts to try.
	 * 2. If no_of_times_login_failed count > 5. User have to wait 24 hours from loginFailedDate till next day.
	 * 2.1 For example if 5th login fails at 22-Jul-2019 19:16:00.000. 
	 * Next success login should allow after 23-Jul-2019 19:16:00.001.
	 *  
	 */
	@Field(value="NO_OF_TIMES_LOGIN_FAILED")
	private Integer no_of_times_login_failed;
	
	/*
	 * 1. Show the user next_success_login_date if no_of_times_login_failed count > 5. 
	 * 2. Send email to user when time exceeds next_success_login_date (Maintain
	 * Thread when it completes "next second" mail should be sent)and provide
	 * security question to authenticate.
	 */
	@Field(value = "NEXT_SUCCESS_LOGIN_DATE")
	private Date next_success_login_date;

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "CustomerId is required field.")
	@NotEmpty(message = "CustomerId is not Empty.")
	@NotBlank(message = "CustomerId is not blank.")
	private String customerId;
	
	@PrePersist
	public void preInsert() {
		if (this.no_of_times_login_failed == null) {
			this.no_of_times_login_failed = 0;
		}
	}
}
