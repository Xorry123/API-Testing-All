package com.APITesting;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class POST_Test01 {
	
	@Test
	public void testcase1() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Rohit");
		map.put("company", "YASH");	
		System.out.println(map);
		
		JSONObject json = new JSONObject(map);
		System.out.println(json.toJSONString());
		
		
	}
	
	@Test
	public void testcase2() {
		

		JSONObject request = new JSONObject();
		request.put("name", "RCB");
		request.put("job", "Cricket");
		
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().		
		statusCode(201).log().all();
		
		
	}		
	

}
