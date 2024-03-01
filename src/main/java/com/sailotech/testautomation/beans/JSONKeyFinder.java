package com.sailotech.testautomation.beans;

import java.util.List;

import org.json.JSONObject;

public class JSONKeyFinder { 
//	TestNodeSingularResponse ts;
//	public static void JSONKeyFinder() { 
//	
//		
////		List<Object> jsonData = ts.getTestCaseSteps();
//		JSONObject jsonObject = new JSONObject(jsonData); 
//		String keyToFind = "testCaseDescription"; 
//		JSONObject foundObject = findKey(jsonObject, keyToFind); 
//		if (foundObject != null) { 
//			System.out.println("Found key '" + keyToFind + "' with value: " + foundObject.get(keyToFind));
//			}
//		else 
//			{ 
//			System.out.println("Key '" + keyToFind + "' not found.");
//			} 
//		} 
	public static JSONObject findKey(JSONObject jsonObject, String keyToFind) { 
		if (jsonObject.has(keyToFind)) {
			return jsonObject;
			} 
		// Recursively search nested objects 
		for (String key : jsonObject.keySet()) {
			Object value = jsonObject.get(key); 
			if (value instanceof JSONObject) { 
				JSONObject foundObject = findKey((JSONObject) value, keyToFind);
				if (foundObject != null) { 
					jsonObject = foundObject;
					return jsonObject;
				}
			} 
		} 
				return jsonObject; 
				} 
	}