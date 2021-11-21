package com.APITesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

public class GET_Test01 {

	String URI = "https://reqres.in/api/users?page=2";
	
	//@Test
	void testcase1() {
		
		Response response = get(URI);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		
	}
	
	
	@Test
	void testcase2() {
		
		given()
			.get(URI).
		then()
			.header("Transfer-Encoding", "chunked")
			.statusCode(200)
			.body("data.id[0]", equalTo(7))
			.body("data.first_name[0]", equalTo("Michael"))
			.body("data.first_name",hasItems("Michael","Lindsay","Tobias"))
			.log().all();
		
		
	}


	
}
