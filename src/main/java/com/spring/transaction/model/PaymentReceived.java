package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PAYMENT_RECEIVED")
public class PaymentReceived {
	
	@Id
	private String paymentReceivedId;

	private BigDecimal actualAmount;
	
	@NotNull(message="Received Amount is required field.")
	private BigDecimal receivedAmount;
    
	private BigDecimal remainingAmount;

    @NotNull(message="Payment Received On is required field.")
	private Date paymentReceivedOn;
    
    @Field(value="CUSTOMER_ID")
	@NotNull(message="Customer is required field.")
	private String customerId;
}
