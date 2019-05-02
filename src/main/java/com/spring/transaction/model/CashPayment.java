package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
/**
 * 
 * @author Priyanka P
 *
 */
@Data
@Document(collection="CASH_PAYMENT")
public class CashPayment {

	@Id private String cashPaymentId;
	private BigDecimal actualAmount;
    private BigDecimal paidAmount;
    private BigDecimal remainingAmount;
    private Date paidOn;
    private BigDecimal recievedAmount;
    private Date recievedOn;
}
