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
	@Field(value = "FUEL_PAYMENT_ID")								private String fuelPaymentId;
	
	@NotNull(message = "Payment By is required field.")
	@Field(value = "PAYMENT_BY_ID")									private String paymentById;
	
	@NotNull(message = "Bill Amount is required field.")
	@Field(value = "BILL_AMOUNT")									private BigDecimal billAmount;
	
	@Field(value = "PAYMENT_ON")									private Date paymentOn;
	@Field(value = "WAIVER_AMOUNT")									private BigDecimal waiverAmount;
	@Field(value = "PAID_AT_LOCATION")								private String paidAtLocation;
	
	/**
	 * 1. Google Location(Longitude, Latitude)
	 */
	@Field(value = "TAG_LOCATION")									private String tagLocation;
	
	@Field(value = "LATITUDE")										private Double latitude;
	@Field(value = "LONGITUDE")										private Double longitude;
	
	@NotNull(message = "Payment Type is required field")
	@Field(value = "PAYMENT_TYPE_ID")								private String paymentTypeId;
	
	@NotNull(message = "Payment Status is required field")
	@Field(value="PAYMENT_STATUS_ID")								private String paymentStatusId;
	
	/**
	 * 1. when cashback received insert fuelPaymentId into fuelPaymentParentId
	 */
	@Field(value = "FUEL_PAYMENT_PARENT_ID")						private String fuelPaymentParentId;
	
	@NotNull(message = "Parent Payment Id is required field.")
	@Field(value = "PARENT_PAYMENT_ID")								private String parentPaymentId;
	
	@NotNull(message="Customer is required field.")
	@Field(value="CUSTOMER_ID")										private String customerId;
}
