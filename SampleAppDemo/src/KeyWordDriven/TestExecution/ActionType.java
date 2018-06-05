package KeyWordDriven.TestExecution;

import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.KeyWordDriven.TestExecution.ActionTypeHelper;
import Framework.BSROException;
import Framework.CoreUtils;
import Framework.FrameWorkObjects;
import Framework.HtmlBrowser;
import Framework.HtmlCheckBox;
import Framework.HtmlCustomSelectDiv;
import Framework.HtmlCustomSelectList;
import Framework.HtmlLink;
import Framework.HtmlSelect;
import Framework.HtmlText;
import Framework.UserConfig;
import Framework.VerificationPoint;
import Framework.jQueryCalendar;
import KeyWordDriven.KeyWordDrivenConstants;
import ProductSpecificFunctions.Store.FindStore.ByFooterLink;
import ProductSpecificFunctions.Store.StoreDetails.VerifyHoliday;


/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class ActionType  {
	/**
	 * Script Name : <b>ActionType</b> Generated : <b>Apr 23, 2013 12:37:06
	 * PM</b> Description : Functional Test Script Original Host : WinNT Version
	 * 6.1 Build 7601 (S)
	 * 
	 * @since 2013/04/23
	 * @author VenkataRaja
	 * @throws BSROException
	 */

	static boolean isComboBox = false;

	static boolean isRadioButton = false;

	static boolean isCheckBox = false;

	static int applicable_Properties_Count = 0;

	static int applicable_Properties_Index = 0;

	/*static Property property_BY_HTML_CLASS = null;

	static Property property_BY_HTML_CSS_CLASS = null;

	static Property property_BY_HTML_CONTENT_TEXT = null;

	static Property property_BY_ELEMENT_ID = null;*/

	public static void doAction(String TC_ACTION_TYPE) throws Exception 
	{

		// CoreUtils.setMouseCursorPositionOutOfScreen();

		//logInfo("Action Type Recevied = " + TC_ACTION_TYPE);

		loadDefaultValues();

		get_HTML_Element_RFT_Identification_Class();

		if (KeyWordDrivenConstants.debug)
		{

			System.out.println("TC_ACTION_TYPE passed to doAction = "+ TC_ACTION_TYPE);

		}

		if (TC_ACTION_TYPE.equals("openBrowser"))
		{

			if (KeyWordDrivenConstants.debug) 
			{

				System.out.println("Processing openBrowserWindow keyword.");

			}

			HtmlBrowser.openBrowserWindow();

		}
		else if (TC_ACTION_TYPE.equals("verifyElementContent")) 
		{

			if (KeyWordDrivenConstants.debug) {

				System.out.println("Processing verifyElementContent keyword.");

			}

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase().equals("BLANK")) 
			{

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} 
			else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH.toUpperCase().equals("BLANK"))
			{

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} 
			else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME.toUpperCase().equals("BLANK"))
			{

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			}

			HtmlBrowser.verifyElementContent(by);

		}
		else if (TC_ACTION_TYPE.equals("loadApplication"))
		{

			if (KeyWordDrivenConstants.debug)
			{

				System.out.println("Processing loadApplication keyword.");

			}

			if (KeyWordDrivenConstants.TC_DATA_DRIVEN_FIELD.equals("YES"))
			{

				if (UserConfig.applicationURL.isEmpty()) 
				{

					HtmlBrowser.loadApplication(KeyWordDrivenConstants.TC_DATA_DRIVEN_VALUE);

				}
				else
				{

					HtmlBrowser.loadApplication(UserConfig.applicationURL);

				}

			} 
			else
			{

				if (UserConfig.applicationURL.isEmpty())
				{

					HtmlBrowser.loadApplication(KeyWordDrivenConstants.TC_EXPECTED);

				} 
				else 
				{

					HtmlBrowser.loadApplication(UserConfig.applicationURL);

				}

			}

		} 
		else if (TC_ACTION_TYPE.equals("loadSitePage"))
		{

			if (KeyWordDrivenConstants.debug) 
			{

				System.out.println("Processing loadApplication keyword.");

			}

			if (KeyWordDrivenConstants.TC_DATA_DRIVEN_FIELD.equals("YES"))
			{

				HtmlBrowser.loadApplication(KeyWordDrivenConstants.TC_DATA_DRIVEN_VALUE);

			}
			else
			{

				HtmlBrowser.loadSpecificPage(KeyWordDrivenConstants.TC_EXPECTED);

			}

		}
		else if(TC_ACTION_TYPE.equals("verifyAllLinksInAPage"))
		{
			
			ByFooterLink.verifyAllLinksInAPage();
			
		}
		else if (TC_ACTION_TYPE.equals("verifyPageTitle"))
		{
			HtmlBrowser.waitForLoad();

			if (KeyWordDrivenConstants.debug)
			{

				System.out.println("Processing verifyPageTitle keyword.");

			}

			String current_Page_Title = HtmlBrowser.getCurrentPageTitle();

			FrameWorkObjects.verificationPoint.verify(1, "MVP1_PageTitle",
					(Object) current_Page_Title,
					(Object) KeyWordDrivenConstants.TC_EXPECTED);

		} 
		else if (TC_ACTION_TYPE.equals("closeBrowser"))
		{

			HtmlBrowser.closeOpenedBrowserWindows();

		} 
		else if (TC_ACTION_TYPE.equals("elementClick")) 
		{

			HtmlBrowser.waitForLoad();

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .className property to list.");
			//
			// property_BY_HTML_CSS_CLASS = new Property(".className",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .contentText property to list.");
			//
			// property_BY_HTML_CONTENT_TEXT = new Property(".contentText",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);
			//
			// System.out.println(".text = "
			// + KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);
			//
			// applicable_Properties_Count += 1;
			//
			// sleep(3);
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			//
			// // property_BY_HTML_CLASS = null;
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CSS_CLASS != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CSS_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CONTENT_TEXT != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CONTENT_TEXT;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (properties.length <= 1) {
			//
			// logInfo("Invoking selenium code to perform action type.");
			//
			// System.out
			// .println("Invoking selenium code to perform action type.");
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH.toUpperCase()
			// .equals("BLANK")) {
			//
			// CoreUtils
			// .elementClickByXPath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);
			//
			// }
			//
			// } else {
			//
			// logInfo("Invoking RFT code to perform action type.");
			//
			// System.out.println("Invoking RFT code to perform action type.");
			//
			// CoreUtils.elementClick(properties);
			// }

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				CoreUtils
						.elementClickByID(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				CoreUtils
						.elementClickByClass(KeyWordDrivenConstants.TC_HTML_ELEMENT_CLASS_NAME);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				CoreUtils
						.elementClickByCssPath(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				CoreUtils
						.elementClickByXPath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT
					.toUpperCase().equals("BLANK")
					&& KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
							.toLowerCase().equals("link")) {

				formatStringForCalendarDate();

				System.out.println("Formatted String = "
						+ KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);

				HtmlLink.clickByLinkText(KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);

			} else {
				throw new BSROException(
						"Unable to perform elementClick() operation.");
			}

		} else if (TC_ACTION_TYPE.equals("elementSelect")) {

			// int applicable_Properties_Count = 0;
			//
			// int applicable_Properties_Index = 0;
			//
			// Property property_BY_HTML_CLASS = null;
			//
			// Property property_BY_HTML_CSS_CLASS = null;
			//
			// Property property_BY_ELEMENT_ID = null;

			// if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Select"))
			// {
			//
			// isComboBox = true;
			//
			// property_BY_HTML_CLASS = new Property(".class", "Html.SELECT");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("RadioButton")) {
			//
			// isRadioButton = true;
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.radio");
			//
			// applicable_Properties_Count += 1;
			//
			// }

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .className property to list.");
			//
			// property_BY_HTML_CSS_CLASS = new Property(".className",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			//
			// // property_BY_HTML_CLASS = null;
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CSS_CLASS != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CSS_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (isComboBox) {
			//
			// HtmlSelect.selectItem(properties,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// } else if (isRadioButton) {
			//
			// HtmlRadioButton.check(properties);
			//
			// }

			// isComboBox = false;
			//
			// isRadioButton = false;
			//
			// if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Select"))
			// {
			//
			// isComboBox = true;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("RadioButton")) {
			//
			// isRadioButton = true;
			//
			// } else {
			// throw new BSROException(
			// "UnKnown element to perform elementSelect() operation.");
			// }
			//
			// if (isComboBox) {
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
			// .equals("BLANK")) {
			//
			// HtmlSelect.selectItemByID_Selenium(
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// } else {
			//
			// throw new BSROException(
			// "Unable to perform elementSelect() method.");
			//
			// }
			//
			// }

			if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.toUpperCase()
					.equals("CUSTOMSELECTLIST")) {

				By by = null;

				if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
						.equals("BLANK")) {

					by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

				} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
						.toUpperCase().equals("BLANK")) {

					by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

				} else {

					throw new BSROException(
							"No component identifier for custom select.");

				}

				HtmlCustomSelectList.select(by,
						KeyWordDrivenConstants.TC_EXPECTED);

			} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
					.toUpperCase().equals("CUSTOMSELECTDIV")) {

				By by = null;

				if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
						.equals("BLANK")) {

					by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

				} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
						.toUpperCase().equals("BLANK")) {

					by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

				} else {

					throw new BSROException(
							"No component identifier for custom select.");

				}

				HtmlCustomSelectDiv.select(by,
						KeyWordDrivenConstants.TC_EXPECTED);

			} else {

				isComboBox = false;

				isRadioButton = false;

				if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
						.equals("Select")) {

					isComboBox = true;

				} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
						.equals("RadioButton")) {

					isRadioButton = true;

				} else {
					throw new BSROException(
							"UnKnown element to perform elementSelect() operation.");
				}

				if (isComboBox) {

					if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID
							.toUpperCase().equals("BLANK")) {

						if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase()
								.startsWith("INDEX=")) {

							int index = Integer
									.parseInt(KeyWordDrivenConstants.TC_EXPECTED
											.trim().toUpperCase()
											.replace("INDEX=", ""));

							HtmlSelect.selectItemByIndex(
									KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
									index);

						} else {

							HtmlSelect.selectItemByID_Selenium(
									KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
									KeyWordDrivenConstants.TC_EXPECTED);

						}

					} else {

						throw new BSROException(
								"Unable to perform elementSelect() method.");

					}

				}
			}

		} else if (TC_ACTION_TYPE.equals("setText")) {
			//
			// int applicable_Properties_Count = 0;
			//
			// int applicable_Properties_Index = 0;
			//
			// Property property_BY_HTML_CLASS = null;
			//
			// Property property_BY_ELEMENT_ID = null;

			// if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Text")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.text");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("Telephone")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.tel");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("Email")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.email");
			//
			// applicable_Properties_Count += 1;
			//
			// }

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.toUpperCase()
			// .equals("TEXT")) {
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// HtmlText.setTextByID(
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// } else {
			//
			// HtmlTelephone.setText(properties,
			// KeyWordDrivenConstants.TC_EXPECTED);
			// }
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .toUpperCase().equals("TELEPHONE")) {
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// HtmlTelephone.setTextByID(
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// } else {
			//
			// HtmlTelephone.setText(properties,
			// KeyWordDrivenConstants.TC_EXPECTED);
			// }
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .toUpperCase().equals("EMAIL")) {
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// HtmlEmail.setTextByID(
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// } else {
			//
			// HtmlEmail.setText(properties,
			// KeyWordDrivenConstants.TC_EXPECTED);
			//
			// }
			//
			// } else {
			//
			// HtmlText.setText(properties, KeyWordDrivenConstants.TC_EXPECTED);
			// }

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			}

			HtmlText.setText(by, KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("verifyElementText")) {

			// int applicable_Properties_Count = 0;
			//
			// int applicable_Properties_Index = 0;
			//
			// Property property_BY_HTML_CLASS = null;
			//
			// Property property_BY_ELEMENT_ID = null;
			//
			// Property property_BY_HTML_CSS_CLASS = null;

			// if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Text")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.text");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("Telephone")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.tel");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("Email")) {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.email");
			//
			// applicable_Properties_Count += 1;
			//
			// }

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .className property to list.");
			//
			// property_BY_HTML_CSS_CLASS = new Property(".className",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			//
			// // property_BY_HTML_CLASS = null;
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CSS_CLASS != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CSS_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }

			// String text = HtmlText.getText(properties);

			// VerificationPoint verificationPoint = new VerificationPoint();
			//
			// verificationPoint.verify(1, "VP_verifyElementText", text,
			// KeyWordDrivenConstants.TC_EXPECTED);

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			}

			String actualValue = HtmlText.getText(by);

		//	logInfo("actual Text Value = " + actualValue);

			//logInfo("expected Text Value = "+ KeyWordDrivenConstants.TC_EXPECTED);

			if (actualValue.equals(KeyWordDrivenConstants.TC_EXPECTED)) {

			//	logInfo("verifyElementText success");

			} else {

				throw new BSROException("verifyElementText() function failed.");

			}

		} else if (TC_ACTION_TYPE.equals("verifySelectedElement")) {

			
			WebElement verifySelectedElement=null;
			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {

				verifySelectedElement = KeyWordDrivenConstants.webDriver.findElement(By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID));
				applicable_Properties_Count += 1;

			}

			if (KeyWordDrivenConstants.debug) {

				System.out
						.println("Properties array size will be initialized to "
								+ applicable_Properties_Count);

			}

		
			String text = verifySelectedElement.getText();
			Assert.assertEquals(KeyWordDrivenConstants.TC_EXPECTED, text);
		

		} else if (TC_ACTION_TYPE.equals("elementCheck")) {

			// int applicable_Properties_Count = 0;
			//
			// int applicable_Properties_Index = 0;
			//
			// Property property_BY_HTML_CLASS = null;
			//
			// Property property_BY_HTML_CSS_CLASS = null;
			//
			// Property property_BY_ELEMENT_ID = null;

			// if
			// (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("CheckBox"))
			// {
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.checkbox");
			//
			// applicable_Properties_Count += 1;
			//
			// }

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .className property to list.");
			//
			// property_BY_HTML_CSS_CLASS = new Property(".className",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			//
			// // property_BY_HTML_CLASS = null;
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CSS_CLASS != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CSS_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }

			// HtmlCheckBox.check(properties);

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			}

			HtmlCheckBox.check(by);

		} else if (TC_ACTION_TYPE.equals("verifyElementCheckedState")) {

			// int applicable_Properties_Count = 0;
			//
			// int applicable_Properties_Index = 0;
			//
			// Property property_BY_HTML_CLASS = null;
			//
			// Property property_BY_HTML_CSS_CLASS = null;
			//
			// Property property_BY_ELEMENT_ID = null;

			// if
			// (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("CheckBox"))
			// {
			//
			// isCheckBox = true;
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.checkbox");
			//
			// applicable_Properties_Count += 1;
			//
			// } else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
			// .equals("RadioButton")) {
			//
			// isRadioButton = true;
			//
			// property_BY_HTML_CLASS = new Property(".class",
			// "Html.INPUT.radio");
			//
			// applicable_Properties_Count += 1;
			//
			// } else {
			//
			// throw new BSROException(
			// "UNKNOWN Element type supplied to verifyElementCheckedState() method.");
			//
			// }

			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.equals("BLANK")) {
			//
			// property_BY_ELEMENT_ID = new Property(".id",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
			// .equals("BLANK")) {
			//
			// System.out.println("Adding .className property to list.");
			//
			// property_BY_HTML_CSS_CLASS = new Property(".className",
			// KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			//
			// applicable_Properties_Count += 1;
			//
			// }
			//
			// if (KeyWordDrivenConstants.debug) {
			//
			// System.out
			// .println("Properties array size will be initialized to "
			// + applicable_Properties_Count);
			//
			// }
			//
			// Property[] properties = new
			// Property[applicable_Properties_Count];
			//
			// if (property_BY_HTML_CLASS != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_HTML_CLASS;
			//
			// applicable_Properties_Index += 1;
			//
			// }
			//
			// if (property_BY_ELEMENT_ID != null) {
			//
			// properties[applicable_Properties_Index] = property_BY_ELEMENT_ID;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// if (property_BY_HTML_CSS_CLASS != null) {
			//
			// properties[applicable_Properties_Index] =
			// property_BY_HTML_CSS_CLASS;
			//
			// applicable_Properties_Index += 1;
			// }
			//
			// String checkedState = "";
			//
			// if (isCheckBox) {
			//
			// checkedState = HtmlCheckBox.getCheckedState(properties);
			//
			// } else if (isRadioButton) {
			//
			// checkedState = HtmlRadioButton.getCheckedState(properties);
			//
			// } else {
			//
			// throw new BSROException(
			// "Unable to get verifyElementCheckedState value.");
			//
			// }
			//
			// logInfo("checkedState = " + checkedState);
			//
			// if (checkedState.equals("SELECTED")) {
			//
			// checkedState = "true";
			//
			// } else {
			//
			// checkedState = "false";
			//
			// }
			//
			// VerificationPoint verificationPoint = new VerificationPoint();
			//
			// verificationPoint.verify(1, "VP_verifyElementCheckedState",
			// checkedState,
			// KeyWordDrivenConstants.TC_EXPECTED.toLowerCase());

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			}

			boolean isChecked = HtmlCheckBox.getCheckedState(by);

			boolean expected = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected = true;

			}

			if (isChecked == expected) {

				//logInfo("verifyElementCheckedState() function success.");

			} else {

				throw new BSROException(
						"verifyElementCheckedState() function failed.");
			}

		} else if (TC_ACTION_TYPE.equals("selectSpecificStore-FooterLink")) {

			// Group task method to select a specific store by using store
			// number.

			ProductSpecificFunctions.Store.SelectStore.ByFooterLink.selectStore(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("selectSpecificStore-HeaderLink")) {

			// Group task method to select a specific store by using store
			// number.

			ProductSpecificFunctions.Store.SelectStore.ByHeaderLink
					.selectStore(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("BLV_YearList")) {

			BLFunctions.BLVerification.YearList.verify();

		} else if (TC_ACTION_TYPE.equals("BLV_ManufacturersList")) {

			BLFunctions.BLVerification.VehicleManufacturerList.verify();

		} else if (TC_ACTION_TYPE.equals("BLV_VehicleModelList")) {

			BLFunctions.BLVerification.VehicleModelList.verify();

		} else if (TC_ACTION_TYPE.equals("BLV_VehicleSubModelList")) {

			BLFunctions.BLVerification.VehicleSubModelList.verify();

		} else if (TC_ACTION_TYPE.equals("verifyElementExist")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT
					.toUpperCase().equals("BLANK")) {

				if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.toUpperCase()
						.equals("LINK")) {

					by = By.linkText(KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);

				} else {

					throw new BSROException(
							"TC_HTML_ELEMENT_CONTENT_TEXT is valid only for links during verifyElementExist()");

				}

			}

			boolean expected_Result = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected_Result = true;

			}

			System.out.println("expected_Result = " + expected_Result);

			System.out.println("actual_Result = "
					+ CoreUtils.isElementPresent(by));

			//logInfo("expected_Result = " + expected_Result);

			//logInfo("actual_Result = " + CoreUtils.isElementPresent(by));

			if (expected_Result == CoreUtils.isElementPresent(by)) {

				//logInfo("Element found");

			} else {

				throw new BSROException("verifyElementExist() function failed.");

			}

		} else if (TC_ACTION_TYPE.equals("switchSpecificFrame")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			HtmlBrowser.switchToIFrame(by);

		} else if (TC_ACTION_TYPE.equals("switchToDefaultFrame")) {

			HtmlBrowser.switchToDefaultFrame();

		} else if (TC_ACTION_TYPE.equals("waitForElementExist")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			boolean expected = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected = true;

			}

			boolean taskStatus = HtmlBrowser.waitForElementExist(by);

		//	logInfo("expected = " + expected);

		//	logInfo("actual = " + taskStatus);

			if (expected == taskStatus) {

			//	logInfo("waitForElementExist() success.");

			} else {

				throw new BSROException("waitForElementExist() failed.");

			}

		} else if (TC_ACTION_TYPE.equals("waitForElementVisible")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			boolean expected = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected = true;

			}

			boolean taskStatus = HtmlBrowser.waitForElementVisible(by);

			//logInfo("expected = " + expected);

			//logInfo("taskStatus = " + taskStatus);

			if (expected == taskStatus) {

			//	logInfo("waitForElementVisible() success.");

			} else {

				throw new BSROException("waitForElementVisible() failed.");

			}

		} else if (TC_ACTION_TYPE.equals("setDate")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			jQueryCalendar.setDate(by, KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("verifyElementVisibleState")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			boolean expected = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected = true;

			}

			boolean actual = CoreUtils.isElementVisible(by);

			if (actual == expected) {

			//	logInfo("verifyElementVisibleState() success.");

			} else {

				throw new BSROException("verifyElementVisibleState() failed.");

			}

		} else if (TC_ACTION_TYPE.equals("verifyElementEnabledState")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			boolean expected = false;

			if (KeyWordDrivenConstants.TC_EXPECTED.toUpperCase().equals("YES")) {

				expected = true;

			}

			boolean actual = CoreUtils.isElementEnabled(by);

			if (actual == expected) {

				//logInfo("verifyElementEnabledState() success.");

			} else {

				throw new BSROException("verifyElementVisibleState() failed.");

			}

		} else if (TC_ACTION_TYPE.equals("mouseOver")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT
					.toUpperCase().equals("BLANK")) {

				if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.toUpperCase()
						.equals("LINK")) {

					by = By.linkText(KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);

				} else {

					throw new BSROException(
							"mouseOver() failed , because TC_HTML_ELEMENT_CONTENT_TEXT is valid only with html links.");

				}

			}

			try {

				CoreUtils.mouseOver(by);

			} catch (Exception e) {
				// TODO: handle exception

				throw new BSROException("mouseOver() function failed.");
			}

		} else if (TC_ACTION_TYPE.equals("backButton")) {

			HtmlBrowser.backButton();

		} else if (TC_ACTION_TYPE
				.equals("verify-flatTires-HomePage-LeftPanel-TiresList")) {

			ProductSpecificFunctions.FlatTires.HomePage
					.verifyLeftPanelTiresList();

		} else if (TC_ACTION_TYPE
				.equals("verify-destinationTires-HomePage-LeftPanel-TiresList")) {

			ProductSpecificFunctions.DestinationTires.HomePage
					.verifyLeftPanelTiresList();

		} else if (TC_ACTION_TYPE
				.equals("verify-blizzakTires-HomePage-LeftPanel-TiresList")) {

			ProductSpecificFunctions.BlizzakTires.HomePage
					.verifyLeftPanelTiresList();

		} else if (TC_ACTION_TYPE
				.equals("verify-turanzaTires-HomePage-LeftPanel-TiresList")) {

			ProductSpecificFunctions.TuranzaTires.HomePage
					.verifyLeftPanelTiresList();

		} else if (TC_ACTION_TYPE
				.equals("verify-ecopiaTires-HomePage-LeftPanel-TiresList")) {

			ProductSpecificFunctions.EcopiaTires.HomePage
					.verifyLeftPanelTiresList();

		} else if (TC_ACTION_TYPE.equals("closePrintWindow")) {

			CoreUtils.closePrintWindow();

		} else if (TC_ACTION_TYPE.equals("verifyPrintWindowExist")) {

			CoreUtils.verifyPrintWindowExists();

		} else if (TC_ACTION_TYPE.equals("switchToSpecficWindow")) {

			HtmlBrowser
					.switchToSpecificWindow(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("closeSpecificWindow")) {

			HtmlBrowser.closeSpecificWindow(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("BLV_TPMS_By_Vehicle_Tires_Widget")) {

			BLFunctions.BLVerification.TPMS
					.verify_TPMS_BL_On_Tires_By_Vehicle_Widget();

		} else if (TC_ACTION_TYPE.equals("clearCookies")) {

			// This is only for Internet Explorer , In future we need to handle
			// for other browsers.
			Framework.HtmlBrowser.clearIECache();

		} else if (TC_ACTION_TYPE.equals("setMouseCursorOutOfScreen")) {

			CoreUtils.setMouseCursorPositionOutOfScreen();

		} else if (TC_ACTION_TYPE.equals("BLV_SetPreferredStore_Header")) {

			BLFunctions.BLVerification.StoreList
					.setPreferedStoreFromPageHeader();

		} else if (TC_ACTION_TYPE.equals("BLV_SetPreferredStore_Footer")) {

			BLFunctions.BLVerification.StoreList
					.setPreferedStoreFromPageFooter();

		} else if (TC_ACTION_TYPE.equals("mouseLeftClick")) {

			By by = null;

			if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_ID.toUpperCase()
					.equals("BLANK")) {

				by = By.id(KeyWordDrivenConstants.TC_HTML_ELEMENT_ID);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH
					.toUpperCase().equals("BLANK")) {

				by = By.xpath(KeyWordDrivenConstants.TC_HTML_ELEMENT_XPATH);

			} else if (!KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME
					.toUpperCase().equals("BLANK")) {

				by = By.cssSelector(KeyWordDrivenConstants.TC_HTML_ELEMENT_CSS_CLASS_NAME);
			}

			CoreUtils.mouseLeftClick(by);

		} else if (TC_ACTION_TYPE.equals("findSpecificStore-FooterLink")) {

			ProductSpecificFunctions.Store.FindStore.ByFooterLink
					.findSpecificStore(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("Get-Directions-Specific-Store")) {

			ProductSpecificFunctions.Store.GetDirections.DirectionsForSpecificStore
					.gotoDirectionsPage(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE
				.equals("selectSpecificStore-ScheduleAppointment")) {

			ProductSpecificFunctions.Store.SelectStore.ByScheduleAppointmentFunnel
					.selectStore(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Store-Results-List-Service-Funnel")) {

			BLFunctions.BLVerification.StoreList
					.verifyStoreListOnServiceFunnel();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Store-Results-List-Product-Funnel")) {

			BLFunctions.BLVerification.StoreList
					.verifyStoreListOnProductFunnel();

		} else if (TC_ACTION_TYPE
				.equals("verify-My-Store-Green-Logo-Selected-Store")) {

			ProductSpecificFunctions.Store.Verification.VerifyMyStoreLogoForSelectedStore
					.verify(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE
				.equals("verify-Continue-Button-Selected-Store")) {

			ProductSpecificFunctions.Store.Verification.VerifyContinueButtonForSelectedStore
					.verify(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE.equals("Get-Details-Specific-Store")) {

			ProductSpecificFunctions.Store.StoreDetails.SpecificStoreDetails
					.gotoStoreDetailsPage(KeyWordDrivenConstants.TC_EXPECTED);

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Lowest-Price")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByLowestPrice
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Highest-Price")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByHighestPrice
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Brand-Name")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByBrand
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Mileage")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByMileage
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Dry-Tracation")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByDryTraction
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Comfort")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsSortByComfort
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Wet")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsByWet
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Winter")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsByWinter
					.verify();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-By-Tread-Wear")) {

			ProductSpecificFunctions.Tires.Search.Verify.Sort.VerifyTireSearchResultsByTreadWear
					.verify();

		} else if (TC_ACTION_TYPE.equals("select-Tyre-Search-Result-Type")) {

			ProductSpecificFunctions.Tires.Search.ResultType.SearchResultType
					.selectResultType();

		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-Filter-By-Brand-Name")) {

			ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.BrandName.VerifyTireSearchResultsByBrandName
					.verify();
		} else if (TC_ACTION_TYPE
				.equals("verify-Standard-Tire-Search-Results-Filter-By-Tyre-Size")) {

			ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.TyreSize.VerifyTireSearchResultsBySize
					.verify();
		} else if (TC_ACTION_TYPE
				.equals("verify-Tire-Search-Comparison-Result")) {

			ProductSpecificFunctions.Tires.Search.Verify.Compare.verifyTireComparisionResult
					.verify();
		} else if (TC_ACTION_TYPE
				.equals("verify-Tire-Search-Performance-Rating-Results")) {

			ProductSpecificFunctions.Tires.Search.Verify.PerformanceRatings.VerifyPerformanceRatings
					.verify();
		} else if (TC_ACTION_TYPE
				.equals("verify-Tire-Search-Get-Quote-Results")) {

			ProductSpecificFunctions.Tires.Search.Verify.Quote.VerifyGetTireQuote
					.verify();
		} else if (TC_ACTION_TYPE.equals("verify-SO-Tire-Search-Results")) {

			ProductSpecificFunctions.Tires.Search.Verify.FilterConditions.StandardOptional.VerifySOFilterTireSearchResults
					.verify();
		} else if (TC_ACTION_TYPE.equals("verify-Tire-Search-Results-Page")) {

			ProductSpecificFunctions.Tires.Search.Verify.Results.VerifyTireSearchResults
					.verify();
		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Tyre-Quote-Search-By-Vehicle")) {

			BLFunctions.BLVerification.TireQuoteByVehicle.verify();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Tyre-Quote-Search-By-Tyre-Size")) {

			BLFunctions.BLVerification.TireQuoteByTyreSize.verify();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Active-Days-Schedule-Appointment")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifyActiveDaysInCalendar();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Same-Day-And-Time-Schedule-Appointment")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifySameDayAndTimeAppointment();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Same-Day-And-Diffrent-Time-Schedule-Appointment-Week-Days")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifySameDayAndDiffrentTimeAppointment();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Same-Day-And-Diffrent-Time-Schedule-Appointment-Min-Time-Diff")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifySameDayAndDiffrentTimeAppointmentMinTimeDiff();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Same-Day-And-Diffrent-Time-Schedule-Appointment-Week-Ends-Before-Noon")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifySameDayAndDiffrentTimeAppointmentsBeforeNoonOnWeekEnds();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Same-Day-And-Diffrent-Time-Schedule-Appointment-Week-Ends-After-Noon")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifySameDayAndDiffrentTimeAppointmentsAfterNoonOnWeekEnds();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Eligible-Timings-Schedule-Appointment-Week-Days")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifyEligibleTimeIntervalsOnWeekDays();

		} else if (TC_ACTION_TYPE
				.equals("BLV-Verify-Eligible-Timings-Schedule-Appointment-Week-Ends")) {

			BLFunctions.BLVerification.ScheduleAppointment
					.verifyEligibleTimeIntervalsOnWeekEndDays();

		} else if (TC_ACTION_TYPE.equals("verify-Battery-Links-Site-Map")) {

			ProductSpecificFunctions.SiteMap.VerifyBatteryLinks.verify();

		} else if (TC_ACTION_TYPE.equals("verify-Tires-Links-Site-Map")) {

			ProductSpecificFunctions.SiteMap.VerifyTiresLinks.verify();

		} else {

			throw new BSROException("Invalid Action Type Identified = "
					+ TC_ACTION_TYPE);

		}

	}

	private static void loadDefaultValues() {

		isComboBox = false;

		isRadioButton = false;

		isCheckBox = false;

		applicable_Properties_Count = 0;

		applicable_Properties_Index = 0;

		

	}

	private static void get_HTML_Element_RFT_Identification_Class() {

		if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Link")) {

		//	property_BY_HTML_CLASS = new Property(".class", "Html.A");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Button")) {

		//	property_BY_HTML_CLASS = new Property(".class", "Html.BUTTON");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Div")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.DIV");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("H1")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.H1");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("H2")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.H2");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("H3")) {

		//	property_BY_HTML_CLASS = new Property(".class", "Html.H3");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("H4")) {

		//	property_BY_HTML_CLASS = new Property(".class", "Html.H4");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("H5")) {

		//	property_BY_HTML_CLASS = new Property(".class", "Html.H5");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Select")) {

			isComboBox = true;

		//	property_BY_HTML_CLASS = new Property(".class", "Html.SELECT");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
				.equals("RadioButton")) {

			isRadioButton = true;

		//	property_BY_HTML_CLASS = new Property(".class", "Html.INPUT.radio");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
				.equals("CheckBox")) {

			isCheckBox = true;

		//	property_BY_HTML_CLASS = new Property(".class","Html.INPUT.checkbox");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Text")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.INPUT.text");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE
				.equals("Telephone")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.INPUT.tel");

			applicable_Properties_Count += 1;

		} else if (KeyWordDrivenConstants.TC_HTML_ELEMENT_TYPE.equals("Email")) {

			//property_BY_HTML_CLASS = new Property(".class", "Html.INPUT.email");

			applicable_Properties_Count += 1;

		}

	}

	private static void formatStringForCalendarDate() throws BSROException {

		if (KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT.contains("#{")) {

			try {

				String[] arguments = KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT
						.split(";");

				for (String arg : arguments) {

					String curentArgument = arg;

					curentArgument.replaceAll(" ", "");

					if (curentArgument.contains("#{currentday}")) {

						if (curentArgument.contains("#{currentday}+")) {

							int today_day = BLFunctions.Utils.DataTime.getCurrentDayByTimeZone("CST", "DD");

							String alterString = curentArgument
									.substring(curentArgument
											.indexOf("#{currentday}+") + 14,
											curentArgument.length());

							System.out.println("today_day = " + today_day);

							System.out.println("alterString= " + alterString);

							Calendar calendar = Calendar.getInstance();

							calendar.add(Calendar.DAY_OF_YEAR,
									Integer.parseInt(alterString));

							int currentMonthNumber = Calendar.getInstance()
									.get(Calendar.MONTH);

							int expectedDateMonth = calendar
									.get(Calendar.MONTH);

						//	logInfo("currentMonthNumber = "+ currentMonthNumber);

						//	logInfo("expectedDateMonth = " + expectedDateMonth);

							if (currentMonthNumber < expectedDateMonth) {

								KeyWordDrivenConstants.webDriver
										.findElement(
												By.xpath("//div[@id='ui-datepicker-div']/div/a[2]"))
										.click();

								HtmlBrowser.waitForLoad();

							}

							String dateFormattedToValidateAsHoliday = ""
									+ (calendar.get(Calendar.MONTH) + 1) + "/"
									+ calendar.get(Calendar.DATE) + "/"
									+ calendar.get(Calendar.YEAR);

							boolean isHoliday = VerifyHoliday
									.isHoliday(dateFormattedToValidateAsHoliday);

							if (Integer.parseInt(alterString) > 1) {

								isHoliday = true;
							}

							int dayIncrementIndex = 1;

							int userExpectedExtraDays = Integer
									.parseInt(alterString.trim());

							int businessDayIdentifierCount = 0;

							while (isHoliday) {

								calendar.add(Calendar.DAY_OF_YEAR,
										dayIncrementIndex);

								dateFormattedToValidateAsHoliday = ""
										+ (calendar.get(Calendar.MONTH) + 1)
										+ "/" + calendar.get(Calendar.DATE)
										+ "/" + calendar.get(Calendar.YEAR);

								isHoliday = VerifyHoliday
										.isHoliday(dateFormattedToValidateAsHoliday);

								if (false == isHoliday) {

									businessDayIdentifierCount += 1;

									System.out
											.println("businessDayIdentifierCount = "
													+ businessDayIdentifierCount);

									System.out
											.println("userExpectedExtraDays = "
													+ userExpectedExtraDays);

									if (businessDayIdentifierCount < userExpectedExtraDays) {

										System.out
												.println("Marking business day found as holiday to get next one.");

										isHoliday = true;

									}

								}

							}

							expectedDateMonth = calendar.get(Calendar.MONTH);

							if (currentMonthNumber < expectedDateMonth) {

								KeyWordDrivenConstants.webDriver
										.findElement(
												By.xpath("//div[@id='ui-datepicker-div']/div/a[2]"))
										.click();

								HtmlBrowser.waitForLoad();

							}

							KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT = ""
									+ calendar.get(Calendar.DATE);

							System.out
									.println("Final String = "
											+ KeyWordDrivenConstants.TC_HTML_ELEMENT_CONTENT_TEXT);

						} else {

							//logError("Invalid operator supplied in string.");

							throw new BSROException(
									"Invalid operator supplied in string.");
						}

					}

				}

			} catch (Exception e) {
				// TODO: handle exception

				//logError("Invalid Formatted String supplied.");

				throw new BSROException(e);
			}

		}

	}
}
