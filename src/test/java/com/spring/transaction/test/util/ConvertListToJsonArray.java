package com.spring.transaction.test.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @Date Mon 16-Mar-2020 16:50
 */
@Slf4j
public class ConvertListToJsonArray {
	
	public static String convertListToJsonArray(List<Object> list) {
		String writeValueAsString = null;
		try {
			writeValueAsString = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			log.error("convertListToJsonArray: {}", e.getMessage());
			e.printStackTrace();
		}
		return writeValueAsString;
	}
}
