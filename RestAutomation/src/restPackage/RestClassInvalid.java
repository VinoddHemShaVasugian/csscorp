package restPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClassInvalid {

	public static void main(String[] args) {
		try {
			int storeNumber = 0;
			int acesVehicleId = 0;
			int i = 0;
			String originalfile = "";
			String currentfile = "";
			for (i = 0; i < 2; i++) {
				if (i == 0) {
					storeNumber = 00000;
					acesVehicleId = 57360;
					originalfile = "./Files/invalidstore/original.txt";
					currentfile = "./Files/invalidstore/current.txt";
				}
				if (i == 1) {
					storeNumber = 11940;
					acesVehicleId = 00000;
					originalfile = "./Files/invalidacesvehicleid/original.txt";
					currentfile = "./Files/invalidacesvehicleid/current.txt";
				}
				Client client = Client.create();
				WebResource webResource = client
						.resource("http://dev01-api-aem.bsro.com/ws2/vehicle/tire/repair-alignment-pricing/get?storeNumber="
								+ storeNumber
								+ "&siteName=FCAC&acesVehicleId="
								+ acesVehicleId + "");
				ClientResponse response = null;
				response = webResource
						.header("appName", "FCAC")
						.header("tokenId",
								"1f04ad80-b947-fe80-32bf4a78a69d54acb")
						.get(ClientResponse.class);
				String jsonStr = response.getEntity(String.class);
				int statuscode = response.getStatus();
				if (statuscode == 200) {
					File expfile = new File(originalfile);
					String expectedJson = FileUtils.readFileToString(expfile);
					File actfile = new File(currentfile);
					FileUtils.writeStringToFile(actfile, jsonStr);
					String actualJson = FileUtils.readFileToString(actfile);
					JSONAssert.assertEquals(expectedJson, actualJson, true);
				} else {
					throw new Exception("status code is not 200");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}