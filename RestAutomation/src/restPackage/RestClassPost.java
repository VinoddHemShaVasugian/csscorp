package restPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClassPost {

	public static void main(String[] args) {
		try {
			String Input = "{\"firstName\": \"Stallin\",\"lastName\": \"Sevugamoorthy\",\"email\": \"test@bfrc.com\",\"address\": \"Spring Hill DR\",\"city\": \"Roselle\",\"state\": \"IL\",\"zip\": \"60172\",\"phone\": \"8269028822\",\"message\": \"Test Webservice contact us\",\"feedbackId\": 1}";
			System.out.println(Input);
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://dev01-api-aem.bsro.com/ws2/contact/us?storeId=892&siteName=FCAC");
			ClientResponse response = null;
			response = webResource.type("application/json")
					.header("appName", "FCAC")
					.header("tokenId", "1f04ad80-b947-fe80-32bf4a78a69d54acb")
					.post(ClientResponse.class, Input);
			String jsonStr = response.getEntity(String.class);
			System.out.println(jsonStr);
			int statuscode = response.getStatus();
			if (statuscode == 200) {
				File expfile = new File("./Files/valid/original.txt");
				String expectedJson = FileUtils.readFileToString(expfile);
				File actfile = new File("./Files/valid/current.txt");
				FileUtils.writeStringToFile(actfile, jsonStr);
				String actualJson = FileUtils.readFileToString(actfile);
				// JSONAssert.assertEquals(expectedJson, actualJson, true);
			} else {
				throw new Exception("status code is not 200");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
