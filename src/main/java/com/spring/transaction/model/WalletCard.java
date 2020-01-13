package com.spring.transaction.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "WALLET_CARD_CODE")
public class WalletCard {
	
	@Id
	@Field(value = "WALLET_CARD_ID", order = 1)
	private String walletCardId;
	
	@Indexed(unique = true, name = "CODE_INDEX", direction = IndexDirection.ASCENDING)
	@TextIndexed
	@NotNull(message = "Wallet Card Code is required field.")
	@Field(value = "CODE", order = 2)
	private String code;

	@Field(value = "POSITION", order = 3)
	private int position;

	@NotNull(message = "Wallet Card Name is required field.")
	@Field(value = "DESCRIPTION", order = 4)
	private String description;
}
