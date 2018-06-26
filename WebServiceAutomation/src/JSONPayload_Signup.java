

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSONPayload_Signup {
  @Test
  public void signUp() {
	  String host="https://dev-css-api-aem.bsro.com/ws2";
	  	RestAssured.baseURI = host;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("appName", "FCAC", "tokenId", "1f04ad80-b947-fe80-32bf4a78a69d54acb");
		httpRequest.contentType("application/json");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName","TTL Testing");
		requestParams.put("lastName","site");
		requestParams.put("address1","1611 Nw Cache Rd");
		requestParams.put("city","Lawton");
		requestParams.put("state","OK");
		requestParams.put("zip","73507");
		requestParams.put("email","ttl@csscorp.com");
		requestParams.put("confirmEmail","ttl@csscorp.com");
		requestParams.put("source","FCAC");	
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post("/contact/email-signup?siteName=FCAC");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Statuscode: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
  }
}
