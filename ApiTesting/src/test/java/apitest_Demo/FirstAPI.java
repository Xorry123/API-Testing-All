package apitest_Demo;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstAPI {
	
	@Test
	
	public void testResponse() {
		Response resp =  RestAssured.get("http://ip.jsontest.com/");
		
		int statuscode = resp.getStatusCode();
		System.out.println("Status Code:" +statuscode);
		assertEquals(statuscode, 200);
	}
	@Test
	public void testBody() {
		Response resp =  RestAssured.get("http://ip.jsontest.com/");
		
		String data = resp.asString();
		System.out.println("Data is:" +data);
		System.out.println("Response Time:- "+resp.getTimeIn(TimeUnit.MILLISECONDS));
	}
}
