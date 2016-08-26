/** Specify the package in which the classes resides */
package datamanagement;

/**
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 26.08.2016
* @version 1.3
* 
* The ListUnitsCTL class is a program that uses private variables to create instances
*with a no-arg constructor.
*
*/

/** change class name from ListUnitsCTL to ListUnitsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListUnitsCTL {		//Start of the class ListUnitsCTL
    private UnitManager um; //need to change variable from um to unitManager_

	/** Construst a default ListUnitsCTL object*/
	public ListUnitsCTL() {		
      um = UnitManager.UM();
	}// End of the no-arg constructor
	
    public void listUnits(IUnitLister lister){	//Start of the method listUnits
	  lister.clearUnits();
	  UnitMap units = um.getUnits();
      for (String s : units.keySet())
          lister.addUnit(units.get(s));
	  }//End of the method listUnits
}//End of the class ListUnitsCTL
