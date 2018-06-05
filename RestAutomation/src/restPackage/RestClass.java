package restPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClass {

	public static void main(String[] args) {
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("https://teamconcert.bsro.com/qm/service/com.ibm.rqm.integration.service.IIntegrationService/resources/BSRO_WebDevelopment+(Quality+Management)/testscript?abbreviate=false/urn:com.ibm.rqm:testscript&;token=_1k-OUd7QEeWBqs-cCd6IBg&amp;page=2");
			ClientResponse response = null;
			response = webResource.header("appName", "FCAC")
					.header("tokenId", "1f04ad80-b947-fe80-32bf4a78a69d54acb")
					.get(ClientResponse.class);
			String jsonStr = response.getEntity(String.class);
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
