package testHTTP;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import org.apache.http.client.HttpClient;
import org.testng.annotations.Test;

import com.sun.security.ntlm.Client;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;





public class SampleTest {

	@Test
	public void getMethod() throws IOException, ParseException {
		
		//Creating a Client
		CloseableHttpClient myclient = HttpClients.createDefault();
		
		//Create a request
		HttpGet req = new HttpGet("https://reqres.in/api/users/2");
		//adding Header
		req.addHeader("Content-Type", "application/json");
		//Execute command
		CloseableHttpResponse response = myclient.execute(req);
		int code  = response.getCode();
		System.out.println("Status Code from Response:-" +code);
		System.out.println("*********************************************/n");
		
		String resposereturned = EntityUtils.toString(response.getEntity(),"UTF-8");
		System.out.println("Response from execute method of HTTPCLient:-" +resposereturned);
		
		System.out.println("*********************************************");
		JsonPath js =new JsonPath(resposereturned);
		int id = js.getInt("data.id");
		System.out.println("Data Traveresal using JSON Path Class:- " +id);
		
		
		System.out.println("*********************************************");
		System.out.println(response.getHeaders().length);
		
		
		
		
		
		
		
		
		
		
		
	}
	


	
	
	
	
	
	

}
