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
 * @version 1.1
 * 
 */

public class XmlManager {
	private static XmlManager self = null;
	private Document document;

	public static XmlManager getXml() {
		if (self == null) {
			self = new XmlManager();
		}
		return self;
	}

	private XmlManager() {
		initialize();
	}

	public void initialize() {
		String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try {
			SAXBuilder builder = new SAXBuilder();
			b.setExpandEntities(true);
			document = builder.build(s);
		} catch (JDOMException exception) {
			System.err.printf("%s", "DBMD: XmlManager : initialize : caught JDOMException\n");
			throw new RuntimeException("DBMD: XmlManager : initialize : JDOMException");
		} catch (IOException exception) {
			System.err.printf("%s", "DBMD: XmlManager : initialize : caught IOException\n");
			throw new RuntimeException("DBMD: XmlManager : initialize : IOException");
		}
	}

	public Document getDocument() {
		return document;
	}

	public void saveDocument() {
		String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try (FileWriter fout = new FileWriter(xmlfile)) {
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(document, fout);
			fout.close();
		} catch (IOException ioe) {
			System.err.printf("%s\n", "DBMD : XmlManager : saveDocument : Error saving XML to " + xmlfile);
			throw new RuntimeException("DBMD: XmlManager : saveDocument : error writing to file");
		}
	}
}
