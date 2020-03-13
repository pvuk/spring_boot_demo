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
@Document(collection = "CURRENT_ADDRESS")
public class CurrentAddress {

	@Id
	@Field(value="CURRENT_ADDRESS_ID", order = 1)
	private ObjectId currentAddressId;

	@Column(length = 3000)
	@Field(value="ADDRESS", order = 2)
	private String address;

	@Field(value="CITY", order = 3)
	private String city;
	
	@Field(value="PIN_CODE", order = 4)
	private String pinCode;

	@Field(value="DISTRICT", order = 5)
	private String district;
	
	@Field(value="STATE", order = 6)
	private String state;

	@Field(value="COUNTRY", order = 7)
	private String country;

	@NotNull(message = "Address is required field.")
	@Field(value="ADDRESS_ID", order = 8)
	private String addressId;
	
	/**
	 * 1. Only one IS_ACTIVE_CURRENT_ADDRESS should be active
	 * 2. Which is recently inserted or updated is going to be IS_ACTIVE_CURRENT_ADDRESS true
	 */
	@Type(type="yes_no")
	@Field(value = "IS_ACTIVE_CURRENT_ADDRESS", order = 9)
	private Boolean isActiveCurrentAddress;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID", order = 10)
	private String customerId;
}
