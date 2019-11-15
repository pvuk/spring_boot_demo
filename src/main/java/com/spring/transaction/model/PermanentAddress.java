package com.spring.transaction.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author venkataudaykiranp
 * 
 *         Note: PERMANENT_ADDRESS columns and CURRENT_ADDRESS columns should be
 *         equal. In some classes
 *         {@link org.springframework.beans.BeanUtils#copyProperties
 *         BeanUtils.copyProperties} method is used to copy entire data from
 *         PermanentAddress to CurrentAddress
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PERMANENT_ADDRESS")
public class PermanentAddress {

	@Field(value="PERMANENT_ADDRESS_ID", order = 1)
	@Id
	private ObjectId permanentAddressId;
	
	@Field(value="ADDRESS", order = 2)
	@Column(length = 3000)
	private String address;

	@Field(value="CITY", order = 3)
	private String city;

	@Field(value="PINCODE", order = 4)
	private String pinCode;
	
	@Field(value="DISTRICT", order = 5)
	private String district;
	
	@Field(value="STATE", order = 6)
	private String state;

	@Field(value="COUNTRY", order = 7)
	private String country;

	@Field(value="ADDRESS_ID", order = 8)
	@NotNull(message = "Address is required field.")
	private String addressId;
	
	/**
	 * 1. IS_ACTIVE_PERMANENT_ADDRESS should be one record for single user
	 * 2. Which is recently inserted or updated is going to be IS_ACTIVE_PERMANENT_ADDRESS true
	 */
	@Field(value = "IS_ACTIVE_PERMANENT_ADDRESS", order = 9)
	@Type(type="yes_no")
	private Boolean isActivePermanentAddress;
	
	@Field(value="CUSTOMER_ID", order = 10)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
