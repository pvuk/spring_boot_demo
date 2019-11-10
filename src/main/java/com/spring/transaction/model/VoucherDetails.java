package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
 * @Date: Sun 10-Nov-2019 15:27
 */
@Data
@Document(collection = "VOUCHER_DETAILS")
public class VoucherDetails {

	@Id
	private String voucherDetailsId;
	private String description;
	private Date receivedOn;
	private Date validFrom;
	private Date validTo;
	private Boolean isActive;
	private Boolean isExpire;
	private Boolean isRedeem;
	private Boolean isShared;

	@Field(value = "CUSTOMER_ID")
	@NotNull(message = "Customer is required field.")
	private String customerId;
}
