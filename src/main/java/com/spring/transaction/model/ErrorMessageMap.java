package com.spring.transaction.model;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ErrorMessageMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	@JsonIgnore
	private HashMap<String, String> aErrorMsgsHM = new HashMap<>();

	public void putErrorMsg(String aKey, String aValue) {
		if (aKey == null)
			aKey = "Null";
		if (aValue == null)
			aValue = "Null";
		aErrorMsgsHM.put(aKey, aValue);
	}

	public boolean hasErrorMsgs() {
		return (!aErrorMsgsHM.isEmpty());
	}

	public void clearErrorMsgs() {
		aErrorMsgsHM.clear();
	}
	/**
	 * public Map getErrorMsgs() { return aErrorMsgsHM; }
	 * 
	 * public void setErrorMsgs( Map aErrorMsgs ) { aErrorMsgsHM = new HashMap( aErrorMsgs ); }
	 */
	
	public String getErrorMsg(String aKey) {
		String errorMessage = null;
		if(aKey != null) {
			errorMessage = this.aErrorMsgsHM.get(aKey);
		}
		return errorMessage;
	}
	
	@JsonIgnore
	public String getAllErrorMsg() {
		StringBuffer errorMessage = new StringBuffer();
		aErrorMsgsHM.keySet().stream().forEach(key -> { 
			errorMessage.append(aErrorMsgsHM.get(key) + "\n");
		});
		return errorMessage.toString();
	}
	
	@JsonIgnore
	public String getErrorStringWithKey() {
		if (!hasErrorMsgs()) {return null;}

	    StringBuffer errorMessage = new StringBuffer();

	    aErrorMsgsHM.keySet().stream().forEach(key -> {
	    	errorMessage.append(key+" | "+getErrorMsg(key)+"\n");
	    });
	      
	      return errorMessage.toString();
	   }
}
