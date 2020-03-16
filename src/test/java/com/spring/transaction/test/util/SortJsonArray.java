package com.spring.transaction.test.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.transaction.test.model.TestJsonModel;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @Date Tue 03-Mar-2020 18:57
 */
@Slf4j
public class SortJsonArray {
	public static void main(String[] args) {
		String pathname = "/src/main/resources/json/put/put-card_status_code.json";
		try {
			ArrayList<Object> arrayList = ReadJsonArrayFile.readJsonArrayFile(pathname);
			
			if(arrayList != null) {
				log.info("Json Array Data: ");
				System.out.println(arrayList);
				
				List<TestJsonModel> list = ConvertJsonArrayToListArrayObject.convertJsonArrayToList(arrayList);
				
				log.info("Before Sort:");
				System.out.println(list);
				
				if(list.size() > 1) {
					List<Object> sortedCodeTestJsonModels = list.stream().sorted(Comparator.comparing(TestJsonModel::getCode)).collect(Collectors.toList());
					log.info("Sort by Code:");
					System.out.println(sortedCodeTestJsonModels);
					
					String writeValueAsString = ConvertListToJsonArray.convertListToJsonArray(sortedCodeTestJsonModels);
					log.info("Convert List to Json Array: ");
					System.out.println(writeValueAsString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
