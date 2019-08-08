package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "FUEL_PAYMENT")
public class FuelPayment {
	
	@Id
	private String fuelPaymentId;
	
	@NotNull(message = "Bill Amount is required field.")
	private BigDecimal billAmount;
	private Date paymentOn;
	private BigDecimal waiverAmount;
	private String paidAtLocation;
	/*
	 * 1. Google Location(Longitude, Latitude)
	 */
	private String tagLocation;
}
