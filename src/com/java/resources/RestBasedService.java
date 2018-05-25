package com.java.resources;

import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

@Path("/sum")
public class RestBasedService {

	@GET
	@Path("/query")
	public String getQueryData() {
		JSONObject jsonObj=null;
		int totalOfKey = 0;

		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:/A Mahesh Drive/test.json"));
			jsonObj = (JSONObject) obj;
			System.out.println("Json -->" + jsonObj.toString());
			
			for (Object key : jsonObj.keySet()) {
				// based on you key types
				String keyStr = (String) key;
				String keyvalue = (String) jsonObj.get(keyStr);
				// Print key and value
				System.out.println("key: " + keyStr + " value: " + keyvalue);
				totalOfKey = totalOfKey + Integer.valueOf(keyStr);
			}
			System.out.println("total -->" + totalOfKey);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return "JSON format = "+jsonObj.toString()+","+ "Result of total Key = "+totalOfKey;

	}
}
