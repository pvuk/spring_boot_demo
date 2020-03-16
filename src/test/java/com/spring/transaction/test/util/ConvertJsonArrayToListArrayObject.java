package com.spring.transaction.test.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.spring.transaction.test.model.TestJsonModel;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @Date Mon 16-Mar-2020 16:41
 */
@Slf4j
public class ConvertJsonArrayToListArrayObject {
	
	public static List<TestJsonModel> convertJsonArrayToList(ArrayList<Object> arrayList) {
		List<TestJsonModel> list = new ArrayList<TestJsonModel>();
		arrayList.forEach(json -> {
			try {
				JSONObject jsonObject = new JSONObject(json.toString());
				String code 		= null;
				Long position 		= null;
				String description 	= null;
				String details 		= null;
				
				if(!StringUtils.isEmpty(jsonObject.getString("code")))
					code			= jsonObject.getString("code").toString();
				
				if(!StringUtils.isEmpty(jsonObject.getLong("position")))
					position 		= (Long) jsonObject.getLong("position");
				
				if(jsonObject.has("description") && !StringUtils.isEmpty(jsonObject.getString("description")))
					description 	= jsonObject.getString("description").toString();
				
				if(jsonObject.has("details"))
					details 		= jsonObject.getString("details").toString();
				
				list.add(TestJsonModel.builder().code(code).position(position).description(description).details(details).build());
			} catch (JSONException e) {
				log.error("convertJsonArrayToList :{} ", e.getMessage());
				e.printStackTrace();
			}
		});
		return list;
	}
}
