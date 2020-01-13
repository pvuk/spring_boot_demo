package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p>When new option is requested by user, need to confirm by Developer and approved by Manager ore rejected by TechSupport</p>
 * 
 * <ul>
 * 	<li>When user 'Other' option is selected from UI control then new request is registered.</li>
 * 	<li>follow steps in Document NEW_OPTION_REQUEST_DETAILS</li>
 * </ul>
 * @author venkataudaykiranp
 * @since Fri 29-Nov-2019 19:47
 */
@Data
@Document(collection = "OTHER_OPTION")
public class OtherOption {
	
	@Id
	@Field(value = "NEW_OPTION_ID")							private String newOptionId;
	
	/**
	 * 1. If option is not found user can request.
	 * 2. When new option(NEW_OPTION_REQUEST_DETAILS_ID) is requested by user, need to CONFIRM_BY Developer and APPROVED_BY Manager ore REJECTED_BY TechSupport.
	 * 3. when new option(NEW_OPTION_REQUEST_DETAILS_ID) is requested by used IS_NEW = 'Y' and date should be from auditData.createDate(CurrentDate)
	 */
	@Type(type="yes_no")
	@Field(value = "IS_NEW") 								private Boolean isNew;
	
	/**
	 * 1. For requesting new option by user display 'Other' value in control.
	 * 2. Once 'Other' selected textbox should be displayed.
	 * 3. NEW_OPTION is 
	 * 2. TEMPORARY_OPTION 'Y' then value should be lighter color than other values. 
	 * 3. Once NEW_OPTION is 'Y' then TEMPORARY_OPTION is 'N' in document NEW_OPTION_REQUEST_DETAILS and DESCRIPTION should be common color.
	 * 
	 */
	@NotNull(message = "Option Name is required field.")
	@Field(value = "NEW_OPTION_REQUEST_DETAILS_ID")			private String newOptionRequestDetailsId;
	
	/**
	 * 1. Once APPROVED is 'Y' in document 'NEW_OPTION_REQUEST_DETAILS' then TEMPORARY_OPTION is 'N' in 'NEW_OPTION_REQUEST_DETAILS' and NEW_OPTION in document 'OTHER_OPTION' is 'Y'.
	 */
	@Type(type = "yes_no")
	@Field(value = "NEW_OPTION")							private Boolean newOption;
	
	/**
	 * 1. RequestBy user through 'Other' option from UI control.
	 */
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")								private String customerId;
}
