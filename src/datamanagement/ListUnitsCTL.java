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
* The ListStudentsCtl class is a program that uses private variables to create instances
*with a no-arg constructor.
*
*/

/** change class name from ListStudentsCTL to ListStudentsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListStudentsCtl {		//Start of the class ListStudentsCtl
    private UnitManager unitManager_;
	/** Construst a default ListStudentsCtl object*/
	public ListStudentsCtl() {		
      unitManager_ = UnitManager.UM();
	}// End of the no-arg constructor
	
    public void listUnits(IUnitLister unitlister){	//Start of the method listUnits
	  unitlister.clearUnits();
	  UnitMap units = unitManager_.getUnits();
      for (String s : units.keySet())
          unitlister.addUnit(units.get(s));
	  }//End of the method listUnits
}//End of the class ListStudentsCtl
