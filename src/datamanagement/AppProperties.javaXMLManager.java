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
 *          XmlManager Class is a program to get and save Documents and using
 *          Xml Manager.
 *
 */

// Start of XmlManager Class

public class XMLManager {
	private static XMLManager self = null; // Private variables . They should be
											// more intutive

	private Document doc;

	public static XMLManager getXML() { // Method to get XML
		if (self == null)
			self = new XMLManager();
		return self;
	}

	private XMLManager() { // Private Constructor
		init();

	}

	public void init() { // Method init
		String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try {
			SAXBuilder b = new SAXBuilder();
			b.setExpandEntities(true);
			doc = b.build(s);
		}

		catch (JDOMException e) {
			System.err.printf("%s", "DBMD: XMLManager : init : caught JDOMException\n");
			throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
		} catch (IOException e) {
			System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");

			throw new RuntimeException("DBMD: XMLManager : init : IOException");
		}
	}

	public Document getDocument() {	Method get Document 
		return doc;
	}

	public void saveDocument() { // Method to save Document
		String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try (FileWriter fout = new FileWriter(xmlfile)) {
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(doc, fout);
			fout.close();
		} catch (IOException ioe) {
			System.err.printf("%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
			throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
		}
	}
}
