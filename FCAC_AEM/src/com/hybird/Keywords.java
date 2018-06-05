package com.hybird;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Keywords {
	public static WebDriver WD;

	/*
	 * String testDataFilePath; int iRowCount=0; String
	 * sFile="TestData/IRCTC.xls";
	 */
	// Constructor to get the required browser.
	public Keywords(String browser) {
		if (browser.equals("Mozilla Firefox")) {
			WD = new FirefoxDriver();
		} else if (browser.equals("Google Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./Drivers/chromedriver.exe");
			WD = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver",
					"./Drivers/IEDriverServer.exe");
			WD = new InternetExplorerDriver();
		}
	}

	// Returning Web driver.
	public WebDriver getDriver() {
		return (WD);
	}

	// To find the element.
	public static WebElement getElement(String locname, String locvalue) {
		WebElement elm = null;
		try {
			WD.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			if (locname.equalsIgnoreCase("id"))
				elm = WD.findElement(By.id(locvalue));
			else if (locname.equalsIgnoreCase("name"))
				elm = WD.findElement(By.name(locvalue));
			else if (locname.equalsIgnoreCase("className"))
				elm = WD.findElement(By.className(locvalue));
			else if (locname.equalsIgnoreCase("linkText"))
				elm = WD.findElement(By.linkText(locvalue));
			else if (locname.equalsIgnoreCase("partialLinkText"))
				elm = WD.findElement(By.partialLinkText(locvalue));
			else if (locname.equalsIgnoreCase("xpath"))
				elm = WD.findElement(By.xpath(locvalue));
			else if (locname.equalsIgnoreCase("cssSelector"))
				elm = WD.findElement(By.cssSelector(locvalue));
			else if (locname.equalsIgnoreCase("tagname"))
				elm = WD.findElement(By.tagName(locvalue));
			else
				System.out.println("Error: invalid locator name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (elm);
	}

	// To click the element.
	public boolean clickElm(String locaname, String locvalue) {
		boolean bStatus = false;
		try {
			WebElement elm = getElement(locaname, locvalue);
			elm.click();
			bStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (bStatus);
	}

	// To enter the given text into text fields.
	public boolean enterText(String locaname, String locvalue, String txt) {
		boolean bStatus = false;
		try {
			WebElement elm = getElement(locaname, locvalue);
			elm.clear();
			elm.sendKeys(txt);
			bStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (bStatus);
	}

	// To select the required values from drop downs.
	public boolean selectItem(String locaname, String locvalue, String itm) {
		boolean bStatus = false;
		Select itms = null;
		try {
			WebElement elm = getElement(locaname, locvalue);
			itms = new Select(elm);
			itms.selectByVisibleText(itm);
			bStatus = true;
		} catch (Exception e) {
			itms.selectByValue(itm);
		}
		return (bStatus);
	}

	// To check/uncheck the check boxes.
	public boolean setElm(String locaname, String locvalue, int val) {
		boolean bStatus = false;
		try {
			WebElement elm = getElement(locaname, locvalue);
			if (val == 1) {
				if (!elm.isSelected())
					elm.click();
				bStatus = true;
			} else if (val == 0) {
				if (elm.isSelected())
					elm.click();
				bStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (bStatus);
	}

	public boolean chkElmSelected(String locaname, String locvalue,
			String expectedResult) {
		boolean bStatus = false;
		try {
			WebElement elm = getElement(locaname, locvalue);
			String sActResult = elm.getText();
			if (elm.isSelected())
				Assert.assertEquals(sActResult, expectedResult);
			Reporter.log("[" + sActResult
					+ "] checkbox is selected & Verification is success", true);
			bStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (bStatus);
	}

	// Working with the elements, which are presented in frame.
	public void switchToFrame(String locaname, String locvalue) {
		WebElement frm = getElement(locaname, locvalue);
		WD.switchTo().frame(frm);
	}

	// To Handle java script pop up's.
	public String switchToAlert(String expectedResult, int action) {
		WebDriverWait wait = new WebDriverWait(WD, 30);
		String sAltMsg = null;
		try {
			Alert alt = wait.until(ExpectedConditions.alertIsPresent());
			alt = WD.switchTo().alert();
			sAltMsg = alt.getText();
			if (sAltMsg.equals(expectedResult)) {
				System.out.println("Pass: Alert message " + expectedResult
						+ " is displayed");
			} else {
				System.out.println("Fail: Alert message " + expectedResult
						+ " is not displayed");
			}
			if (action == 1) {
				alt.accept();
			} else if (action == 2) {
				alt.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sAltMsg;
	}

	// To verify the messages.
	public void verifyText(String locaname, String locvalue,
			String expectedResult) {
		WebElement elm = getElement(locaname, locvalue);
		String sActResult = elm.getText();
		Assert.assertEquals(sActResult, expectedResult);
		Reporter.log("[" + sActResult
				+ "] is displayed & Verification is success", true);
	}

	// To verify the expected page using page title
	public void verifyPageTitle(String expectedResult) {
		String pageTitle = WD.getTitle();
		Assert.assertEquals(pageTitle, expectedResult);
		Reporter.log(pageTitle + " page is displayed & test case passed", true);
	}

	// To take the screen shots.
	public void screenShot(String fileName) {
		TakesScreenshot t = (TakesScreenshot) WD;
		File capture = t.getScreenshotAs(OutputType.FILE);
		File save = new File("./ScreenShots/" + fileName + ".jpg");
		try {
			FileUtils.copyFile(capture, save);
		} catch (IOException e) {
			System.out.println("ScreenShot not captured.");
		}
	}

	// To read the data from Excel sheet using poi jar file.
	public static String getData(String path, String Sheet, int r, int c) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("getData - File not available");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			System.out.println("getData - File format is not xlsx");
		}
		String data = wb.getSheet(Sheet).getRow(r).getCell(c)
				.getStringCellValue();
		return data;
	}
}
/*
 * //To verify the messages. public void VerifyText(String locaname,String
 * locvalue,String expectedResult) { WebElement elm =
 * getElement(locaname,locvalue); String sActResult = elm.getText();
 * Assert.assertEquals(sActResult, expectedResult); Reporter.log(sActResult +
 * " is displayed & test case passed", true); try {
 * Assert.assertEquals(sActResult, expectedResult); Reporter.log(sActResult +
 * " is displayed & test case passed", true); } catch (AssertionError e) {
 * Reporter.log(sActResult + " is not displayed & test case Failed", true);
 * Assert.assertEquals( "Exception message :", "Exception", e.getMessage());
 * Assert.assertEquals(
 * "\n Expectation failure on verify:\n throwsNothing(true): expected: 2, actual: 1"
 * ,e.getMessage()); } }
 */
/*
 * //To read the data from Excel sheet using jsx jar file public List<String[]>
 * getXlData(String sTestData) throws IOException { String tdata[][] = null;
 * //testData=new ArrayList(); testDataFilePath=sTestData; int startrow=1;
 * boolean bExit=false; FileInputStream inputWorkbook = new
 * FileInputStream(testDataFilePath); jxl.Workbook wb=null; try { wb =
 * jxl.Workbook.getWorkbook(inputWorkbook); //wb =
 * Workbook.getWorkbook(inputWorkbook); // Get the first sheet Sheet sheet =
 * wb.getSheet(0); tdata = new String[sheet.getRows()][sheet.getColumns()]; for
 * (int i=0;i<sheet.getRows();i++){ for (int j=0;j<sheet.getColumns();j++){ Cell
 * cell=sheet.getCell(j,i); tdata[i][j]=cell.getContents();
 * 
 * }// end for j loop
 * 
 * }// end for i loop return(Arrays.asList(tdata)); } catch (BiffException e) {
 * e.printStackTrace(); return(Arrays.asList(tdata)); }
 * 
 * }//End parseXLTestCase
 */
/*
 * //To read the data from Excel sheet using JDBC connectivity public int
 * getRowCount(String test) { try{
 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection con =
 * DriverManager.getConnection(
 * "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="
 * + sFile); Statement stSqlStmt =
 * con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
 * ResultSet.CONCUR_READ_ONLY); ResultSet testData =
 * stSqlStmt.executeQuery("Select * from [Login$] where test='" + test + "'");
 * // int iCols = testData.getMetaData().getColumnCount(); if (testData.last()){
 * iRowCount = testData.getRow(); } con.close(); } catch(Exception e){
 * e.printStackTrace(); } return(iRowCount);
 * 
 * }
 * 
 * 
 * public String getData(String test,String iter,String field) { String
 * sData=null; try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
 * con = DriverManager.getConnection(
 * "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="
 * + sFile + ";ReadOnly=0;"); Statement stSqlStmt = con.createStatement();
 * ResultSet testData =
 * stSqlStmt.executeQuery("Select * from [Login$] where test='" + test +
 * "' and iteration='" + iter + "'" ); if (testData.last()){ iRowCount =
 * testData.getRow(); }
 * 
 * if(iRowCount == 1) sData = testData.getString(field); con.close();
 * }catch(Exception e){ e.printStackTrace(); } return(sData); }
 * 
 * 
 * 
 * public void putData(int no ,String mail, String ph) { try{
 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection con =
 * DriverManager.getConnection(
 * "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="
 * + sFile + ";ReadOnly=0;"); Statement stSqlStmt = con.createStatement(); int
 * iRow = stSqlStmt.executeUpdate("insert into [Sheet1$] Values(" + no + ",'" +
 * mail + "','" + ph +"',"+ null + "," + null+","+ null + "," + null + ")"); if
 * (iRow>0) iRowCount = iRow; con.close(); }catch(Exception e){
 * e.printStackTrace(); } }
 */