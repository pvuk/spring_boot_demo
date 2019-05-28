package com.spring.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BANK_CODE")
public class Bank {

	@Id
	@Field(value = "BANK_ID", order = 1)
	private String bankId;

	@Field(value = "BANK_NAME", order = 2)
	@Indexed(unique = true)
	@NotNull(message = "Bank Name Can't be empty.")
	@NotBlank(message = "Bank Name is required field.")
	private String bankName;
	
	private Date establishedOn;
	
	private Long establishedYear;
	
	private String headQuarter;
	
	private Long branches;
	
	private BigDecimal revenues;
	
	private String strRevenues;
	
	private BigDecimal totalAssets;
	
	private String strTotalAssets;
	
	private String notes;
	
	private String refLink;
	
	@DBRef
	@Field(value="BANK_TYPE")
	private BankType bankType;

	@Builder.Default
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
	
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", establishedOn=" + establishedOn
				+ ", establishedYear=" + establishedYear + ", headQuarter=" + headQuarter + ", branches=" + branches
				+ ", revenues=" + revenues + ", strRevenues=" + strRevenues + ", totalAssets=" + totalAssets
				+ ", strTotalAssets=" + strTotalAssets + ", notes=" + notes + ", refLink=" + refLink + ", bankType="
				+ bankType + ", errorMessageMap=" + errorMessageMap + "]";
	}
	
}
