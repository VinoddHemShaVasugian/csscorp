package restPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClassExcel {

	public static void main(String[] args) throws Exception {

		String path = "./Files/WebServiceInput.xls";
		// String path = "./Files/WebServiceInput.xlsx";
		// used apache poi for reading and writing in the excel
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		Sheet sheet = wb.getSheetAt(0);

		// for loop to iterate over till the last column of the excel sheet
		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
			// for (int j = 1; j <= 67; j++) {

			int statuscode = 0;
			String alignmentQuoteIdandexceptions = "";
			String alignmentQuoteId = "";
			String exceptionss = "";
			String checkparam = "";
			String ParamString = "";
			String Input = "";
			int Param = 0;
			String jsonStr = "";
			String AlignmentQuoteId = "";
			String jsonStrPost = "";
			String expectedJson = "";
			String Url = "";
			String Method = "";
			String header = "";
			String key1, key2, key3, value1, value2, value3 = "";
			ClientResponse response = null;
			ClientResponse postresponse = null;
			Row row = sheet.getRow(j);
			System.out.println(j);
			Cell responsecheckparameter = row.getCell(12);
			if (responsecheckparameter != null) {

				checkparam = responsecheckparameter.getStringCellValue();
				System.out.println(checkparam);

			}

			if (checkparam == "") {

				Cell CellReadUrl = row.getCell(1);
				if (CellReadUrl != null) {

					Url = CellReadUrl.getStringCellValue();

				}

				Cell CellReadMethod = row.getCell(2);
				if (CellReadMethod != null) {

					Method = CellReadMethod.getStringCellValue();

				}

				Client client = Client.create();
				WebResource webResource = client.resource(Url);

				Cell CellReadParam = row.getCell(5);
				if (CellReadParam != null) {
					DataFormatter formatter = new DataFormatter();
					ParamString = formatter.formatCellValue(CellReadParam);
					Param = Integer.parseInt(ParamString);

				}

				if (Param == 1) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1).get(
								ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}

				}

				if (Param == 2) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}
				}

				if (Param == 3) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					Cell CellReadParamkey3 = row.getCell(10);
					Cell CellReadParamvalue3 = row.getCell(11);

					key3 = CellReadParamkey3.getStringCellValue();
					value3 = CellReadParamvalue3.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).header(key3, value3)
								.get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.header(key3, value3)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}
				}

				FileOutputStream statusout = new FileOutputStream(
						new File(path));

				Cell writestatuserror = row.getCell(16);
				if (writestatuserror == null) {
					writestatuserror = row.createCell(16);
				}
				writestatuserror.setCellType(Cell.CELL_TYPE_STRING);
				writestatuserror.setCellValue(statuscode);
				wb.write(statusout);
				statusout.close();

				Cell CellReadexpectedJson = row.getCell(17);

				expectedJson = CellReadexpectedJson.getStringCellValue();

				FileOutputStream out = new FileOutputStream(new File(path));

				Cell writeactualJson = row.getCell(18);
				if (writeactualJson == null) {
					writeactualJson = row.createCell(18);
				}
				writeactualJson.setCellType(Cell.CELL_TYPE_STRING);
				writeactualJson.setCellValue(jsonStr);
				wb.write(out);
				out.close();

				if (statuscode == 400 || statuscode == 404) {
					try {
						if (expectedJson.equals(jsonStr)) {

							FileOutputStream success = new FileOutputStream(
									new File(path));

							Cell writeerrorsuccess = row.getCell(19);
							if (writeerrorsuccess == null) {
								writeerrorsuccess = row.createCell(19);
							}
							writeerrorsuccess
									.setCellType(Cell.CELL_TYPE_STRING);
							writeerrorsuccess
									.setCellValue("Webservice works fine");
							wb.write(success);
							success.close();
						} else {
							FileOutputStream notmatched = new FileOutputStream(
									new File(path));
							Cell nomatch = row.getCell(19);
							if (nomatch == null) {
								nomatch = row.createCell(19);
							}
							nomatch.setCellType(Cell.CELL_TYPE_STRING);
							nomatch.setCellValue("expected and actual are not equal");
							wb.write(notmatched);
							notmatched.close();
						}
					} catch (Exception e) {
						FileOutputStream exception = new FileOutputStream(
								new File(path));
						Cell writeexception = row.getCell(19);
						if (writeexception == null) {
							writeexception = row.createCell(19);
						}
						writeexception.setCellType(Cell.CELL_TYPE_STRING);
						writeexception.setCellValue(e.getMessage());
						wb.write(exception);
						exception.close();
					}

				}

				else {

					try {
						JSONAssert.assertEquals(expectedJson, jsonStr, true);

						FileOutputStream successout = new FileOutputStream(
								new File(path));

						Cell writesuccess = row.getCell(19);
						if (writesuccess == null) {
							writesuccess = row.createCell(19);
						}
						writesuccess.setCellType(Cell.CELL_TYPE_STRING);
						writesuccess.setCellValue("Webservice works fine");
						wb.write(successout);
						successout.close();

					} catch (AssertionError | JSONException e) {

						FileOutputStream exceptionout = new FileOutputStream(
								new File(path));
						String exception = e.getMessage();
						if (exception.contains("payload.createdDate")) {

							FileOutputStream successout = new FileOutputStream(
									new File(path));
							Cell writesuccess = row.getCell(19);
							if (writesuccess == null) {
								writesuccess = row.createCell(19);
							}
							writesuccess.setCellType(Cell.CELL_TYPE_STRING);
							writesuccess.setCellValue("Webservice works fine");
							wb.write(successout);
							successout.close();
						} else {
							Cell writeassertionerror = row.getCell(19);
							if (writeassertionerror == null) {
								writeassertionerror = row.createCell(19);
							}
							writeassertionerror
									.setCellType(Cell.CELL_TYPE_STRING);
							writeassertionerror.setCellValue(e.getMessage());
							wb.write(exceptionout);
							exceptionout.close();

						}
					}

				}

				// Read from excel column Response check parameter if null -do
				// nothing, if its alignment then call the corresponsing
				// alignment response check function,
				// it will print any exception in Response check Success/Error
				// message
				// Finally it will print the value returned by that function in
				// Response check return value column
			} else if (checkparam.equals("alignment")) {
				Cell CellReadUrl = row.getCell(1);
				if (CellReadUrl != null) {

					Url = CellReadUrl.getStringCellValue();

				}

				Cell CellReadMethod = row.getCell(2);
				if (CellReadMethod != null) {

					Method = CellReadMethod.getStringCellValue();

				}

				Client client = Client.create();
				WebResource webResource = client.resource(Url);

				Cell CellReadParam = row.getCell(5);
				if (CellReadParam != null) {
					DataFormatter formatter = new DataFormatter();
					ParamString = formatter.formatCellValue(CellReadParam);
					Param = Integer.parseInt(ParamString);

				}

				if (Param == 1) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1).get(
								ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}

				}

				if (Param == 2) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}
				}

				if (Param == 3) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue1 = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue1.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					Cell CellReadParamkey3 = row.getCell(10);
					Cell CellReadParamvalue3 = row.getCell(11);

					key3 = CellReadParamkey3.getStringCellValue();
					value3 = CellReadParamvalue3.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).header(key3, value3)
								.get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.header(key3, value3)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

						System.out.println(jsonStr);

					}
				}
				FileOutputStream statusout = new FileOutputStream(
						new File(path));

				Cell writestatuscode = row.getCell(16);
				if (writestatuscode == null) {
					writestatuscode = row.createCell(16);
				}
				writestatuscode.setCellType(Cell.CELL_TYPE_STRING);
				writestatuscode.setCellValue(statuscode);
				wb.write(statusout);
				statusout.close();

				FileOutputStream out = new FileOutputStream(new File(path));

				Cell writeactualJson = row.getCell(18);
				if (writeactualJson == null) {
					writeactualJson = row.createCell(18);
				}
				writeactualJson.setCellType(Cell.CELL_TYPE_STRING);
				writeactualJson.setCellValue(jsonStr);
				wb.write(out);
				out.close();

				Cell CellReadParamvalue1 = row.getCell(7);

				value1 = CellReadParamvalue1.getStringCellValue();
				System.out.println(value1);

				if (value1.equals("FCAC")) {
					jsonresponsecheck jsonresponsecheck = new jsonresponsecheck();
					alignmentQuoteIdandexceptions = jsonresponsecheck
							.AlignmentresponsecheckFCAC(jsonStr);
					System.out.println(alignmentQuoteIdandexceptions);
				} else {
					jsonresponsecheck jsonresponsecheck = new jsonresponsecheck();
					alignmentQuoteIdandexceptions = jsonresponsecheck
							.AlignmentresponsecheckTP(jsonStr);
					System.out.println(alignmentQuoteIdandexceptions);
				}
				String[] parts = alignmentQuoteIdandexceptions.split(";");
				System.out.println(parts.length);
				if (parts.length == 1) {
					alignmentQuoteId = parts[0];
					System.out.println(alignmentQuoteId);
					exceptionss = "webservice works fine";
					long time = System.currentTimeMillis();
					System.out.println(exceptionss + " : " + time);
				} else {
					alignmentQuoteId = parts[0];
					exceptionss = parts[1];
					System.out.println(alignmentQuoteId);
					System.out.println(exceptionss);
				}
				FileOutputStream alignmentquoteid = new FileOutputStream(
						new File(path));
				Cell writealignmentquoteid = row.getCell(13);
				if (writealignmentquoteid == null) {
					writealignmentquoteid = row.createCell(13);
				}
				writealignmentquoteid.setCellType(Cell.CELL_TYPE_STRING);
				writealignmentquoteid.setCellValue(alignmentQuoteId);
				wb.write(alignmentquoteid);
				alignmentquoteid.close();

				FileOutputStream exceptions = new FileOutputStream(new File(
						path));
				Cell writeexception = row.getCell(19);
				if (writeexception == null) {
					writeexception = row.createCell(19);
				}
				writeexception.setCellType(Cell.CELL_TYPE_STRING);
				writeexception.setCellValue(exceptionss);
				wb.write(exceptions);
				exceptions.close();

			} else if (checkparam.equals("alignment compare")) {

				int k = j - 1;

				Row beforerow = sheet.getRow(k);

				Cell CellReadAlignmentQuote = beforerow.getCell(13);
				if (CellReadAlignmentQuote != null) {

					AlignmentQuoteId = CellReadAlignmentQuote
							.getStringCellValue();
					System.out.println(AlignmentQuoteId);

				}
				Cell CellReadParamvalue1 = row.getCell(7);

				value1 = CellReadParamvalue1.getStringCellValue();

				if (value1.equals("FCAC")) {
					Cell CellReadUrl = row.getCell(1);
					if (CellReadUrl != null) {

						String OriginalUrl = CellReadUrl.getStringCellValue();
						System.out.println(OriginalUrl);
						String RemainingUrl = AlignmentQuoteId
								+ "&siteName=FCAC";
						Url = OriginalUrl + RemainingUrl;

					}
				} else {
					Cell CellReadUrl = row.getCell(1);
					if (CellReadUrl != null) {

						String OriginalUrl = CellReadUrl.getStringCellValue();
						System.out.println(OriginalUrl);
						String RemainingUrl = AlignmentQuoteId + "&siteName=TP";
						Url = OriginalUrl + RemainingUrl;
					}
				}

				Cell CellReadMethod = row.getCell(2);
				if (CellReadMethod != null) {

					Method = CellReadMethod.getStringCellValue();

				}

				Client client = Client.create();
				WebResource webResource = client.resource(Url);

				Cell CellReadParam = row.getCell(5);
				if (CellReadParam != null) {
					DataFormatter formatter = new DataFormatter();
					ParamString = formatter.formatCellValue(CellReadParam);
					Param = Integer.parseInt(ParamString);

				}

				if (Param == 1) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1).get(
								ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}

				}

				if (Param == 2) {

					System.out.println("inside param 2");
					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}
				}

				if (Param == 3) {

					Cell CellReadParamkey1 = row.getCell(6);
					Cell CellReadParamvalue = row.getCell(7);

					key1 = CellReadParamkey1.getStringCellValue();
					value1 = CellReadParamvalue.getStringCellValue();

					Cell CellReadParamkey2 = row.getCell(8);
					Cell CellReadParamvalue2 = row.getCell(9);

					key2 = CellReadParamkey2.getStringCellValue();
					value2 = CellReadParamvalue2.getStringCellValue();

					Cell CellReadParamkey3 = row.getCell(10);
					Cell CellReadParamvalue3 = row.getCell(11);

					key3 = CellReadParamkey3.getStringCellValue();
					value3 = CellReadParamvalue3.getStringCellValue();

					if (Method.equals("Get")) {

						response = webResource.header(key1, value1)
								.header(key2, value2).header(key3, value3)
								.get(ClientResponse.class);

						jsonStr = response.getEntity(String.class);

						statuscode = response.getStatus();

					} else {

						Cell CellReadInput = row.getCell(3);
						if (CellReadInput != null) {

							Input = CellReadInput.getStringCellValue();

						}

						postresponse = webResource.type("application/json")
								.header(key1, value1).header(key2, value2)
								.header(key3, value3)
								.post(ClientResponse.class, Input);

						jsonStr = postresponse.getEntity(String.class);

						statuscode = postresponse.getStatus();

					}
				}

				FileOutputStream statusout = new FileOutputStream(
						new File(path));

				Cell writestatus = row.getCell(16);
				if (writestatus == null) {
					writestatus = row.createCell(16);
				}
				writestatus.setCellType(Cell.CELL_TYPE_STRING);
				writestatus.setCellValue(statuscode);
				wb.write(statusout);
				statusout.close();

				Cell CellReadexpectedJson = beforerow.getCell(18);

				expectedJson = CellReadexpectedJson.getStringCellValue();

				FileOutputStream out = new FileOutputStream(new File(path));

				Cell writeactualJson = row.getCell(18);
				if (writeactualJson == null) {
					writeactualJson = row.createCell(18);
				}
				writeactualJson.setCellType(Cell.CELL_TYPE_STRING);
				writeactualJson.setCellValue(jsonStr);
				wb.write(out);
				out.close();

				try {
					JSONAssert.assertEquals(expectedJson, jsonStr, true);

					FileOutputStream successout = new FileOutputStream(
							new File(path));

					Cell writesuccess = row.getCell(19);
					if (writesuccess == null) {
						writesuccess = row.createCell(19);
					}
					writesuccess.setCellType(Cell.CELL_TYPE_STRING);
					writesuccess.setCellValue("Webservice works fine");
					wb.write(successout);
					successout.close();

				} catch (AssertionError | JSONException e) {

					FileOutputStream exceptionout = new FileOutputStream(
							new File(path));
					String exception = e.getMessage();
					if (exception.contains("payload.createdDate")
							|| exception.contains("payload[0].id")
							|| exception.contains("payload.tires")) {

						FileOutputStream successout = new FileOutputStream(
								new File(path));
						Cell writesuccess = row.getCell(19);
						if (writesuccess == null) {
							writesuccess = row.createCell(19);
						}
						writesuccess.setCellType(Cell.CELL_TYPE_STRING);
						writesuccess.setCellValue("Webservice works fine");
						wb.write(successout);
						successout.close();
					} else {
						Cell writeassertionerror = row.getCell(19);
						if (writeassertionerror == null) {
							writeassertionerror = row.createCell(19);
						}
						writeassertionerror.setCellType(Cell.CELL_TYPE_STRING);
						writeassertionerror.setCellValue(e.getMessage());
						wb.write(exceptionout);
						exceptionout.close();

					}
				}

			}
		}
		System.out.println("Web Service testing is Completed!!!");
	}

}
