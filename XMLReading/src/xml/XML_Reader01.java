package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_Reader01 {

	public static void main(String[] args) throws Exception, Throwable {
		File file = new File("./Files/test.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
//		document.getDocumentElement().normalize();

	    System.out.println("Root element :" + document.getDocumentElement().getNodeName());
	    NodeList nList = document.getElementsByTagName("staff");
	    System.out.println("----------------------------");
	    System.out.println("Value 1 :" + document.getXmlVersion());
	    for (int temp = 0; temp < nList.getLength(); temp++) {
	        Node nNode = nList.item(temp);
	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            System.out.println("Staff id : "+ eElement.getAttribute("id"));
	            System.out.println("First Name : "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
	            System.out.println("Last Name : "
	                               + eElement.getElementsByTagName("lastname")
	                                 .item(0).getTextContent());
	            System.out.println("Nick Name : "
	                               + eElement.getElementsByTagName("nickname")
	                                 .item(0).getTextContent());
	            System.out.println("Salary : "
	                               + eElement.getElementsByTagName("salary")
	                                 .item(0).getTextContent());
	        }
	    }
//	    catch (Exception e) {
//	    e.printStackTrace();
//	    }

	}

}
