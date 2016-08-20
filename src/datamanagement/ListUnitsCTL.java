/** 
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @date 20.08.2016
*/
package datamanagement;

/** change class name from ListStudentsCTL to ListStudentsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListStudentsCtl {		//Start of the class
    private UnitManager um;
	/** Construst a default ListStudentsCtl object*/
	public ListStudentsCtl() {		
      um = UnitManager.UM();
	}
    public void listUnits(IUnitLister lister){	//Start of the method
	  lister.clearUnits();UnitMap units = um.getUnits();
      for (String s : units.keySet())
          lister.addUnit(units.get(s));
	  }//End of the method
}//End of the class
