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
	
	@Field(value="PAYMENT_RECEIVED_ID", order = 1)
	@Id
	private String paymentReceivedId;

	@Field(value="ACTUAL_AMOUNT", order = 2)
	private BigDecimal actualAmount;
	
	@Field(value="RECEIVED_AMOUNT", order = 3)
	@NotNull(message="Received Amount is required field.")
	private BigDecimal receivedAmount;
    
	@Field(value="REMAINING_AMOUNT", order = 4)
	private BigDecimal remainingAmount;

	@Field(value="PAYMENT_RECEIVED_ON", order = 5)
    @NotNull(message="Payment Received On is required field.")
	private Date paymentReceivedOn;
	
	@Field(value="PAYMENT_STATUS_ID", order = 6)
	private String paymentStatusId;
	
	@Field(value="CONFIRM_PAYMENT", order = 7)
	private Boolean confirmPayment;
    
    @Field(value="CUSTOMER_ID", order = 8)
	@NotNull(message="Customer is required field.")
	private String customerId;
}
