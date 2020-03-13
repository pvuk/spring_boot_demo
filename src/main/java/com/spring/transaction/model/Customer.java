package com.spring.transaction.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.spring.transaction.model.audit.AuditData;

import lombok.Data;

@Data
@Document(collection="CUSTOMER")
public class Customer {
	
	@Id
	@Field(value = "CUSTOMER_ID", order = 1)
	private String customerId;
	
	@Field(value = "USER_NAME", order = 2)
	private String userName;

	@Field(value = "login_Name", order = 3)
	private String loginName;

	@Field(value = "LAST_LOGIN_DATE", order = 4)
	private Date lastLoginDate;

	@Field(value = "USER_FUNCTION_ID", order = 5)
	private Long userFunctionId;

	@Field(value = "USER_LOCATION_ID", order = 6)
	private Long userLocationId;

	@Field(value = "EMAIL", order = 7)
	private String email;

	@Field(value = "FIRST_NAME", order = 8)
	private String firstName;
	
	@Field(value = "MIDDLE_NAME", order = 9)
	private String middleName;
	
	@Field(value = "LAST_NAME", order = 10)
	private String lastName;
	
	@Field(value = "DATE_OF_BIRTH", order = 11)
	private Date dateOfBirth;
	
	@NotNull(message= "Address is required field")
	@Field(value = "ADDRESS_ID", order = 12)
	private String addressId;
	
	@Field(value = "EMPLOYEER_ID", order = 13)
	private String employeerId;
	
	@Embedded
	private AuditData auditData;
}
