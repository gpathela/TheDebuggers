/** Importing some of java Libreries 
 *  Specify the package in which class resides 
 */
package datamanagement;

import java.util.List;
import org.jdom.*;

/**
 * @reviewer Gourav Pathela
 * @course Master of Information Technology
 * @subject Professional Programming Practice
 * @lecturer Dr Recep Ulusoy
 * @due date 26.08.2016
 * @version 1.3
 * 
 *          UnitManager class implements IUnit . The main purpose of class is to
 *          create and get units . It use methods like getUnit to find the
 *          details of unit. It also createUnit method to create the new units.
 *
 */

// Start of UnitManager Class
public class UnitManager {

	private static UnitManager self = null; // Private Class Variables

	private UnitMap UM;

	public static UnitManager UM() {
		if (self == null)
			self = new UnitManager();
		return self;
	}

	private UnitManager() { // Private Constructor
		UM = new UnitMap();
	}

	public IUnit getUnit(String uc) { // Method to get Units
		IUnit iu = UM.get(uc);
		return iu != null ? iu : createUnit(uc);

	}

	private IUnit createUnit(String unitCode) { // Method to create Unit

		IUnit iu; // This varibals hould be more readable.

		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;

				slist = null;
				iu = new Unit(el.getAttributeValue("uid"), el.getAttributeValue("name"),
						Float.valueOf(el.getAttributeValue("ps")).floatValue(),
						Float.valueOf(el.getAttributeValue("cr")).floatValue(),
						Float.valueOf(el.getAttributeValue("di")).floatValue(),
						Float.valueOf(el.getAttributeValue("hd")).floatValue(),
						Float.valueOf(el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt")).intValue(),
						StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
				UM.put(iu.getUnitCode(), iu);
				return iu;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	} // End of method to create Unit

	public UnitMap getUnits() { // Method to get Units

		UnitMap uM; // Variables should be more intutive.
		IUnit iu;

		uM = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit")) {
			iu = new UnitProxy(el.getAttributeValue("uid"), el.getAttributeValue("name"));
			uM.put(iu.getUnitCode(), iu);
		} // unit maps are filled with PROXY units
		return uM;
	}

}
