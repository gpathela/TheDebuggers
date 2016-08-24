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

	private static UnitManager unitManager = null; // Private static variable of
													// type UnitManager

	private UnitMap unitMap_; // Private variable of type UnitMap

	public static UnitManager unitManager() { // Method with return type as
												// UnitManager
		if (unitManager == null)
			unitManager = new UnitManager();
		return unitManager;
	} // End of Method

	private UnitManager() { // Private Constructor
		unitManager = new UnitMap();
	}

	public IUnit getUnit(String unitCode) { // Method to get unitCode or call
											// for create new
		IUnit iUnit = unitManager.get(unitCode);
		return iUnit != null ? iUnit : createUnit(unitCode);

	} // End of getUnit Method

	private IUnit createUnit(String unitCode) { // Method to create unit if not
												// exists

		IUnit iUnit;

		for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(element.getAttributeValue("uid"))) {
				StudentUnitRecordList studentList;

				studentList = null;
				iUnit = new Unit(element.getAttributeValue("uid"), element.getAttributeValue("name"),
						Float.valueOf(element.getAttributeValue("ps")).floatValue(),
						Float.valueOf(element.getAttributeValue("cr")).floatValue(),
						Float.valueOf(element.getAttributeValue("di")).floatValue(),
						Float.valueOf(element.getAttributeValue("hd")).floatValue(),
						Float.valueOf(element.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(element.getAttributeValue("asg1wgt")).intValue(),
						Integer.valueOf(element.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(element.getAttributeValue("examwgt")).intValue(),
						StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
				unitManager.put(iUnit.getUnitCode(), iUnit);
				return iUnit;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	} // End of method to create unit

	public UnitMap getUnits() { // Method to get existing units

		UnitMap unitMap;
		IUnit iUnit;

		unitMap = new UnitMap();
		for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit")) {
			iUnit = new UnitProxy(el.getAttributeValue("uid"), element.getAttributeValue("name"));
			unitMap.put(iUnit.getUnitCode(), iUnit);
		} // unit maps are filled with PROXY units
		return unitMap;
	} // End of method to get Units

}
