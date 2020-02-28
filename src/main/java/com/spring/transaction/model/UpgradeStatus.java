package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "UPGRADE_STATUS_CODE")
public class UpgradeStatus {

	@Id
	@Field(value = "UPGRADE_STATUS_ID")
	private String upgradeStatusId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@Field(value="CODE")																	private String code;
	
	@Field(value="POSITION") 																private Long position;
	
	@NotNull(message="Upgrade Status is required field.")
	@Field(value="DESCRIPTION") 															private String description;
}
