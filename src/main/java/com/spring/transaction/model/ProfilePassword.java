package com.spring.transaction.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
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
	
	@NotNull(message = "Password is required field.")
	@Field(value = "PASSWORD")
	private String password;
	
	@Type(type="yes_no")
	@Field(value = "IS_ACTIVE")
	private boolean isActive;
	
	/**
	 * 1. If the user forgot and try after 4 hours / next day before
	 * next_success_login_date don't update loginFailedDate
	 */
	@Field(value="LOGIN_FAILED_DATE_AND_TIME")
	private Date loginFailedDateAndTime;
	
	/**
	 * 1. Allow the user upto 5 attempts to try.
	 * 2. If NO_OF_TIMES_LOGIN_FAILED count > 5. User have to wait 24 hours from LOGIN_FAILED_DATE till next day.
	 * 2.1 For example if 5th login fails at 22-Jul-2019 19:16:00.000. 
	 * Next success login should allow after 23-Jul-2019 19:16:00.001.
	 *  
	 */
	@Field(value="NO_OF_TIMES_LOGIN_FAILED")
	private Integer no_of_times_login_failed;
	
	/**
	 * 1. Show the user NEXT_SUCCESS_LOGIN_DATE_AND_TIME if no_of_times_login_failed count > 5. 
	 * 2. Send email to user when time exceeds NEXT_SUCCESS_LOGIN_DATE_AND_TIME.
	 * NOTE: (Maintain Thread when it completes "next second" mail should be sent)and provide
	 * security question to authenticate.
	 */
	@Field(value = "NEXT_SUCCESS_LOGIN_DATE_AND_TIME")
	private Date next_success_login_date_and_time;

	@NotNull(message = "CustomerId is required field.")
	@Field(value = "CUSTOMER_ID")
	private String customerId;
	
	@PrePersist
	public void preInsert() {
		if (this.no_of_times_login_failed == null) {
			this.no_of_times_login_failed = 0;
		}
	}
}
