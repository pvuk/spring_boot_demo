package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
 *         PermanentAddress to CurrentAddress.
 *         <br>
 *         <b>Common Address using classes: </b> {@link com.spring.transaction.service.impl.BankBranchServiceImpl#save BankBranchServiceImpl.save}  
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ADDRESS")
public class Address {

	@Field(value = "ADDRESS_ID", order = 1)
	@Id
	private ObjectId addressId;

	/*
	 * 1. IS_PERMANENT_ADDRESS is same as IS_CURRENT_ADDRESS copy all data from
	 * PERMANENT_ADDRESS into CURRENT_ADDRESS to their respective fields
	 */
	@Field(value = "IS_PERMANENT_ADDRESS_IS_SAME_AS_CURRENT_ADDRESS", order = 2)
	@NotNull(message = "Permanent Address is required field.")
	/**
	 * if we use @Type annotation value is going to be save either 'Y' or 'N'
	 */
	@Type(type="yes_no")
	private Boolean isPermanentAddressIsSameAsCurrentAddress;
	
	@Field(value = "PERMANENT_ADDRESS_ID", order = 3)
	@NotNull(message = "Permanent Address is required field.")
	private ObjectId permanentAddressId;

	/*
	 * IS_CURRENT_ADDRESS can be many for single user
	 * If new address is added maintain it in current_address
	 */
	@Field(value = "CURRENT_ADDRESS_ID", order = 4)
	@NotNull(message = "Current Address is required field.")
	private ObjectId currentAddressId;
	
	@Field(value="CUSTOMER_ID", order = 5)
	@NotNull(message="Customer is required field.")
	private String customerId;
	
	@Transient
	private PermanentAddress permanentAddress;
	
	@Transient
	private CurrentAddress currentAddress;
}
