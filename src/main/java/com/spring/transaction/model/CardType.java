package com.spring.transaction.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CARD_TYPE_CODE")
public class CardType {

	@Field(value = "CARD_TYPE_ID", order = 1)
	@Id
	private String cardTypeId;

	@Field(value = "CODE", order = 2)
	private String code;
	
	@Field(value = "POSITION", order = 3)
	private int position;
	
	@Field(value = "DESCRIPTION", order = 4)
	@NotEmpty(message = "Card Type is required field.")
	private String description;
	
	@Field(value = "IS_VERTUAL_CARD", order = 5)
	private boolean isVertualCard;
	
	@Field(value = "COMMENTS", order = 6)
	private String comments;

	@Transient
	private ErrorMessageMap errorMessageMap = new ErrorMessageMap();
	
	public CardType setErrorMessageMap(String aKey, String aValue) {
		errorMessageMap.putErrorMsg(aKey, aValue);
		return this;
	}

	@Override
	public String toString() {
		return "CardType [cardTypeId=" + cardTypeId + ", code=" + code + ", position=" + position + ", description="
				+ description + ", errorMessageMap=" + errorMessageMap + "]";
	}
}
