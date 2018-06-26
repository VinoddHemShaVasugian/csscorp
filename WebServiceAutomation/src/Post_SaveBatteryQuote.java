

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_SaveBatteryQuote {
  @Test
  public void SaveQuoteBattery() {
	  	  
	  	String host="https://dev-css-api-aem.bsro.com/ws2";
	  	RestAssured.baseURI = host;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("appName", "FCAC", "tokenId", "1f04ad80-b947-fe80-32bf4a78a69d54acb");
		httpRequest.contentType("application/json");
		
		httpRequest.queryParameters("year","2010","make","Honda","model","Accord","engine","V6/3.5L","storeNumber","24147","productCode","MT-24F","zip","35801-5932","siteName","FCAC");
		Response response = httpRequest.post("/vehicle/battery/save/battery-quote");

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
