package com.spring.transaction.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p>
 * 	1. If any payment using CC and user want to pay particular transaction / full payment using DC / NetBanking / App.
 * 	2. If transaction done on CC and save the transaction in web and AssignPaymentBy using DC payment.
 * 	3. Warns the user if they tried to pay using other options(NetBanking / App) other than DC.
 * 	4. ASSIGN_PAYMENT_CODE is mandatory field. User can select any option i.e DC / CC / Wallet / UPI / NetBanking.
 * </p>
 * @author P V UdayKiran
 *
 * @since Tue 03-Dec-2019 18:10
 */
@Data
@Document(collection = "ASSIGN_PAYMENT_BY")
public class AssignPaymentBy {
	
	@Field(value = "ASSIGN_PAYMENT_BY_ID")
	@Id
	private String assignPaymentById;
	
	@Field(value="AMOUNT")
	@NotNull(message="Amount is required field.")
	private BigDecimal amount;
	
	@Field(value = "COMMENT")
	private String comment;
	
	@Field(value = "ASSIGN_PAYMENT_ID")
	@NotNull(message="Assign Payment is required field.")
	private String assignPaymentId;
}
