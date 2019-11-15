package com.spring.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 
 * UPI is a banking system for money transfers on payment apps. To add a bank
 * account to Google Pay / other banking apps / wallets, your bank must work with UPI. Your UPI ID is an
 * address that identifies you on UPI (typically yourname@bankname).
 * 
 * @author Priyanka
 *
 * @Date Sun 10-Nov-2019 12:25
 */
@Data
public class UPIWallet {

	/**
	 * "upi_wallet_id": null, "upi_id": "PVUK@ICICI", "mobile_number": "9603xx2x58",
	 * "description": "", "upi_app_code": "imobile"
	 */

	@Id
	@Field(value = "UPI_WALLET_ID")
	private String upiWalletId;
	
	@Field(value = "UPI_ID")
	private String upiId;
	
	private String mobileNumber;
	
	private String description;
	
	private String upiAppCode;
	
	/**
	 * 1. If multiple UPI_ID exist, allow only one primary UPI to pay / receive the amount
	 */
	private Boolean isPrimary = false;
	
	/**
	 * 1. if user contains more than one upi id, whenever if upi id changed to primary this field should be update.
	 */
	@Field("PRIMARY_ACCOUNT_UPDATED_ON")
	private Date primaryAccountUpdatedOn;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
