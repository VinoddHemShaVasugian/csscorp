package restPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class jsonresponsecheck extends RestClassExcel {

	public String AlignmentresponsecheckFCAC(String jsonStr) {

		String alignmentQuoteId = "";
		StringBuilder exceptions = new StringBuilder();
		try {

			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONObject payload = jsonObj.getJSONObject("payload");

			try {
				if (!jsonObj.isNull("statusCode")) {

					String statusCode = jsonObj.getString("statusCode");
					System.out.println(statusCode);
					if (statusCode.equals("SUCCESSFUL")) {
						System.out.println("statusCode matches");
					} else {
						throw new Exception("statusCode does not match");
					}
				}

				else {
					throw new Exception("statusCode is Null");
				}
			} catch (Exception e) {

				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("alignmentQuoteId")) {

					alignmentQuoteId = payload.getString("alignmentQuoteId");
					System.out.println(alignmentQuoteId);
				}

				else {
					throw new Exception("alignmentQuoteId is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("firstName")) {

					String firstName = payload.getString("firstName");
					System.out.println(firstName);
					if (firstName.equals("Testing")) {
						System.out.println("firstName matches");
					} else {
						throw new Exception("firstName does not match");
					}
				}

				else {
					throw new Exception("firstName is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("lastName")) {

					String lastName = payload.getString("lastName");
					System.out.println(lastName);
					if (lastName.equals("test")) {
						System.out.println("lastName matches");
					} else {
						throw new Exception("lastName does not match");
					}
				}

				else {
					throw new Exception("lastName is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("storeNumber")) {

					String storeNumber = payload.getString("storeNumber");
					System.out.println(storeNumber);
					if (storeNumber.equals("9245")) {
						System.out.println("storeNumber matches");
					} else {
						throw new Exception("storeNumber does not match");
					}
				}

				else {
					throw new Exception("storeNumber is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("zip")) {

					String zip = payload.getString("zip");
					System.out.println(zip);
					if (zip.equals("60525-7271")) {
						System.out.println("zip matches");
					} else {
						throw new Exception("zip does not match");
					}
				}

				else {
					throw new Exception("zip is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("alignmentPricingId")) {

					String alignmentPricingId = payload
							.getString("alignmentPricingId");
					System.out.println(alignmentPricingId);
					if (alignmentPricingId.equals("1")) {
						System.out.println("alignmentPricingId matches");
					} else {
						throw new Exception("alignmentPricingId does not match");
					}
				}

				else {
					throw new Exception("alignmentPricingId is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("createdDate")) {

					String createdDate = payload.getString("createdDate");
					System.out.println(createdDate);
				}

				else {
					throw new Exception("createdDate is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("emailAddress")) {

					String emailAddress = payload.getString("emailAddress");
					System.out.println(emailAddress);
					if (emailAddress.equals("humesh.kumar@csscorp.com")) {
						System.out.println("emailAddress matches");
					} else {
						throw new Exception("emailAddress does not match");
					}
				}

				else {
					throw new Exception("emailAddress is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			exceptions.append(e.getMessage() + ":");
		}
		return alignmentQuoteId + ";" + exceptions;
	}

	public String AlignmentresponsecheckTP(String jsonStr) {

		String alignmentQuoteId = "";
		StringBuilder exceptions = new StringBuilder();
		try {

			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONObject payload = jsonObj.getJSONObject("payload");

			try {
				if (!jsonObj.isNull("statusCode")) {

					String statusCode = jsonObj.getString("statusCode");
					System.out.println(statusCode);
					if (statusCode.equals("SUCCESSFUL")) {
						System.out.println("statusCode matches");
					} else {
						throw new Exception("statusCode does not match");
					}
				}

				else {
					throw new Exception("statusCode is Null");
				}
			} catch (Exception e) {

				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("alignmentQuoteId")) {

					alignmentQuoteId = payload.getString("alignmentQuoteId");
					System.out.println(alignmentQuoteId);
				}

				else {
					throw new Exception("alignmentQuoteId is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("firstName")) {

					String firstName = payload.getString("firstName");
					System.out.println(firstName);
					if (firstName.equals("Testing")) {
						System.out.println("firstName matches");
					} else {
						throw new Exception("firstName does not match");
					}
				}

				else {
					throw new Exception("firstName is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("lastName")) {

					String lastName = payload.getString("lastName");
					System.out.println(lastName);
					if (lastName.equals("test")) {
						System.out.println("lastName matches");
					} else {
						throw new Exception("lastName does not match");
					}
				}

				else {
					throw new Exception("lastName is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("storeNumber")) {

					String storeNumber = payload.getString("storeNumber");
					System.out.println(storeNumber);
					if (storeNumber.equals("256664")) {
						System.out.println("storeNumber matches");
					} else {
						throw new Exception("storeNumber does not match");
					}
				}

				else {
					throw new Exception("storeNumber is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("zip")) {

					String zip = payload.getString("zip");
					System.out.println(zip);
					if (zip.equals("19067-3513")) {
						System.out.println("zip matches");
					} else {
						throw new Exception("zip does not match");
					}
				}

				else {
					throw new Exception("zip is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("alignmentPricingId")) {

					String alignmentPricingId = payload
							.getString("alignmentPricingId");
					System.out.println(alignmentPricingId);
					if (alignmentPricingId.equals("3")) {
						System.out.println("alignmentPricingId matches");
					} else {
						throw new Exception("alignmentPricingId does not match");
					}
				}

				else {
					throw new Exception("alignmentPricingId is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("createdDate")) {

					String createdDate = payload.getString("createdDate");
					System.out.println(createdDate);
				}

				else {
					throw new Exception("createdDate is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

			try {
				if (!payload.isNull("emailAddress")) {

					String emailAddress = payload.getString("emailAddress");
					System.out.println(emailAddress);
					if (emailAddress.equals("humesh.kumar@csscorp.com")) {
						System.out.println("emailAddress matches");
					} else {
						throw new Exception("emailAddress does not match");
					}
				}

				else {
					throw new Exception("emailAddress is Null");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				exceptions.append(e.getMessage() + ":");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			exceptions.append(e.getMessage() + ":");
		}
		return alignmentQuoteId + ";" + exceptions;
	}
}
