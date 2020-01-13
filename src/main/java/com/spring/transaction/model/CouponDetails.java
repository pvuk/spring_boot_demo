package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * Coupon is a voucher entitling the holder to a discount off a particular
 * product and service also can be in a newspaper or magazine which may be sent
 * as an application for a purchase or information.
 * 
 * @author Priyanka
 *
 * @Date Sun 10-Nov-2019 15:28
 */
@Data
@Document(collection = "COUPON_DETAILS")
public class CouponDetails {

	@Id
	@Field(value = "COUPON_DETAILS_ID")						private String couponDetailsId;
	
	@Field(value = "DESCRIPTION")							private String description;
	
	@Field(value = "RECEIVED_ON")							private Date receivedOn;
	
	@Field(value = "VALID_FROM")							private Date validFrom;
	
	@Field(value = "VALID_TO")								private Date validTo;
	
	@Type(type="yes_no")
	@Field(value = "IS_ACTIVE")								private Boolean isActive;
	
	@Type(type="yes_no")
	@Field(value = "IS_EXPIRE")								private Boolean isExpire;
	
	@Type(type="yes_no")
	@Field(value = "IS_REDEEM")								private Boolean isRedeem;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")							private String customerId;
}
