package com.spring.transaction.model;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CURRENT_BANK_ACCOUNT")
public class CurrentBankAccount {
	
	private String CurrentBankAccountId;
	
	@Column(name = "BANK_ID")
	private String bankId;
}
