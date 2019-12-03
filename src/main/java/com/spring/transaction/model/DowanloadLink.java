package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * <p>
 * 	1. CODE should be equal to WALLET_CODE / BANK_CODE / CREDIT_CARD_CODE / GIFT_CARD_CODE / NET_BANKING_CODE
 * </p>
 * @author P V UdayKiran
 *
 * @Date: Tue 03-Dec-2019 21:38
 */
@Data
@Document(collection = "DOWNLOAD_LINK")
public class DowanloadLink {
	
	@Field(value="DOWNLOAD_LINK_ID", order = 1)
	@Id 													private String dowanloadLinkId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@NotNull(message = "Download Load Code is required field.")
	@Field(value="CODE", order = 2) 						private String code;
	
	@Field(value="POSITION", order = 3) 					private Long position;
	
	@NotNull(message="Download Load Link Description is required field.")
	@Field(value="DESCRIPTION", order = 4) 					private String description;
	
	@Field(value = "ANDROID_LINK", order = 5)				private String androidLink;
	@Field(value = "IOS_LINK", order = 6)					private String iosLink;
	@Field(value = "WEB_LINK", order = 7)					private String webLink;
}
