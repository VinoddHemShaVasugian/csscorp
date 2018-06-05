package RQM;

import java.io.File;

import model.DBMock;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Framework.BSROException;



import com.sun.org.apache.xerces.internal.parsers.DOMParser;


/**
 * Description : Functional Test Script
 * 
 * @author VenkataRaja
 */
public class RQMUtils  {
	/**
	 * Script Name : <b>RQMUtils</b> Generated : <b>Jun 4, 2013 1:17:49 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7601 (S)
	 * 
	 * @since 2013/06/04
	 * @author VenkataRaja
	 * @throws BSROException
	 */
	public static String getTestCaseName()throws BSROException {

		String rqmTestCaseName = "";

		String rqmProjectName = "";

		try {

			for (String number : DBMock.tc_id)
			{
				rqmTestCaseName=number;
				System.out.println("Number = " + number);
				break;
			} 

		}

		catch (Exception e)
		{

			throw new BSROException(e);

		}

		return rqmTestCaseName;

	}

}
