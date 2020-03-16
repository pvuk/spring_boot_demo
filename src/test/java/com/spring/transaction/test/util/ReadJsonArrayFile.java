package com.spring.transaction.test.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 * @Date Mon 16-Mar-2020 16:37
 */
@Slf4j
public class ReadJsonArrayFile {
	
	public static ArrayList<Object> readJsonArrayFile(String pathname) throws Exception {
		File file = new File(System.getProperty("user.dir") + pathname);
		InputStream iStream = null;
		ArrayList<Object> arrayList = null;
		try {
			if(file.exists()) {
				JSONParser jsonParser = new JSONParser(new FileReader(file));
				arrayList = jsonParser.parseArray();
			} else {
				log.error("File not found in path: {}", file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(iStream != null)
				try {
					iStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return arrayList;
	}
}
