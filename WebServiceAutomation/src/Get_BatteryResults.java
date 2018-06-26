

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_BatteryResults {
  @Test
  public void BatteryResult() {
		String host="https://css-api-aem.bsro.com/ws2";
	  	RestAssured.baseURI = host;
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.headers("appName", "FCAC", "tokenId", "1f04ad80-b947-fe80-32bf4a78a69d54acb");
		httpRequest.parameters("year","2007","make","Nissan","model","Maxima","engine","V6/3.5L");
		Response response = httpRequest.get("/vehicle/battery/get/search-results");

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
