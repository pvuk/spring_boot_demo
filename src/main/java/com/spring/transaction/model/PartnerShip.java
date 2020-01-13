package com.spring.transaction.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="PARTNER_SHIP")
public class PartnerShip {
	
	@Id
	@Field(value="PARTNER_SHIP_ID", order = 1)
	private String partnerShipId;
	
	@Field(value="MERCHANT_DETAILS_ID", order = 2)
	private String merchantDetailsId;

	/*
	 * if extended partnership is selected then no need to insert column data of
	 * parternShipFrom and partnerShipTill
	 */
	@Field(value="EXTENDED_PARTNER_SHIP", order = 3)
	private Boolean extendedPartnerShip;
	
	@Field(value="PARTERN_SHIP_FROM", order = 4)
	private Date parternShipFrom;
	
	@Field(value="PARTNER_SHIP_TILL", order = 5)
	private Date partnerShipTill;
	
}
