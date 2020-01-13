package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <a href=
 * "https://www.quora.com/What-is-the-difference-between-voucher-coupons-gift-card-and-cash-back-offer">Voucher</a>
 * is a small printed piece of paper that entitles the holder to a discount, or
 * that may be exchanged for goods or services.
 * 
 * @author Priyanka
 *
 * @since Sun 10-Nov-2019 15:27
 */
@Data
@Document(collection = "VOUCHER_DETAILS")
public class VoucherDetails {

	@Id
	@Field(value = "VOUCHER_DETAILS_ID")						private String voucherDetailsId;
	
	@Field(value = "DESCRIPTION")								private String description;
	
	@Field(value = "RECEIVED_ON")								private Date receivedOn;
	
	@Field(value = "VALID_FROM")								private Date validFrom;
	
	@Field(value = "VALID_TO")									private Date validTo;
	
	@Type(type="yes_no")
	@Field(value = "IS_ACTIVE")									private Boolean isActive;
	
	@Type(type="yes_no")
	@Field(value = "IS_EXPIRE")									private Boolean isExpire;
	
	@Type(type="yes_no")
	@Field(value = "IS_REDEEM")									private Boolean isRedeem;
	
	@Type(type="yes_no")
	@Field(value = "IS_SHARED")									private Boolean isShared;

	@NotNull(message = "Customer is required field.")
	@Field(value = "CUSTOMER_ID")								private String customerId;
}
