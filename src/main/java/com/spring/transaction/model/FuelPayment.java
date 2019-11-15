package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "FUEL_PAYMENT")
public class FuelPayment {
	
	@Id
	@Field(value = "FUEL_PAYMENT_ID")						private String fuelPaymentId;
	
	@NotNull(message = "Payment By is required field.")
	private String paymentById;
	
	@NotNull(message = "Bill Amount is required field.")
	private BigDecimal billAmount;
	private Date paymentOn;
	private BigDecimal waiverAmount;
	private String paidAtLocation;
	
	/**
	 * 1. Google Location(Longitude, Latitude)
	 */
	private String tagLocation;
	
	@Field(value = "PAYMENT_TYPE_ID")
	@NotNull(message = "Payment Type is required field")
	private String paymentTypeId;
	
	/**
	 * 1. when cashback received insert fuelPaymentId into fuelPaymentParentId
	 */
	private String fuelPaymentParentId;
	
	@Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")				private String customerId;
	
	@Field(value = "PARENT_PAYMENT_ID")
	@NotNull(message = "Parent Payment Id is required field.")	private String parentPaymentId;
}
