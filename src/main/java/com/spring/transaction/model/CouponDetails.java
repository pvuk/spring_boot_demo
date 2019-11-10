package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
 * @Date: Sun 10-Nov-2019 15:28
 */
@Data
@Document(collection = "COUPON_DETAILS")
public class CouponDetails {

	@Id
	@Field(value = "COUPON_DETAILS_ID")						private String couponDetailsId;
	
	private String description;
	private Date receivedOn;
	private Date validFrom;
	private Date validTo;
	private Boolean isActive;
	private Boolean isExpire;
	private Boolean isRedeem;

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
