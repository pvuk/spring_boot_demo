package com.spring.transaction.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="PARTNER_SHIP")
public class PartnerShip {
	
	@Id private String partnerShipId;
	
	private String merchantDetailsId;

	/*
	 * if extended partnership is selected then no need to insert column data of
	 * parternShipFrom and partnerShipTill
	 */
	private Boolean extendedPartnerShip;
	
	private Date parternShipFrom;
	
	private Date partnerShipTill;
	
}
