/** Import some Java libraries and specify the package in which class resides */
package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 * @reviewer Gourav Pathela
 * @course Master of Information Technology
 * @subject Professional Programming Practice
 * @lecturer Dr Recep Ulusoy
 * @due date 26.08.2016
 * @version 1.3
 * 
 *          XmlManager Class
 *
 */

// Start of XmlManager Class

public class XmlManager {
	private static XmlManager xmlManager = null; // Declaring and initiating
													// private static XmlManager
													// type variable
	private Document document; // Declaring variable document of Type Document

	public static XmlManager getXml() { // Get Method for returning xmlManager
										// value
		if (xmlManager == null) {
			xmlManager = new XmlManager();
		}
		return xmlManager;
	} // End of getXml method

	private XmlManager() { // Private Constructor of class
		initialize(); // Calling initialize method
	} // End of private constructor

	public void initialize() { // Initialize method
		String string = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			saxBuilder.setExpandEntities(true);
			document = saxBuilder.build(string);
		} catch (JDOMException jdomException) {
			System.err.printf("%s", "DBMD: XmlManager : initialize : caught JDOMException\n");
			throw new RuntimeException("DBMD: XmlManager : initialize : JDOMException");
		} catch (IOException ioException) {
			System.err.printf("%s", "DBMD: XmlManager : initialize : caught IOException\n");
			throw new RuntimeException("DBMD: XmlManager : initialize : IOException");
		}
	} // End of initialize method

	public Document getDocument() { // Get method with return type of Document
		return document;
	} // End of getDocument method

	public void saveDocument() { // saveDocument method with return type of void
		String xmlFile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try (FileWriter fileWriter = new FileWriter(xmlFile)) {
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.output(document, fileWriter);
			fileWriter.close();
		} catch (IOException ioException) {
			System.err.printf("%s\n", "DBMD : XmlManager : saveDocument : Error saving XML to " + xmlFile);
			throw new RuntimeException("DBMD: XmlManager : saveDocument : error writing to file");
		}
	} // End of saveDocument Method
}
