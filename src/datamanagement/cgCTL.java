/** Displaying the package in which the class resides */
package datamanagement;
/**
* This class allows the instantiation of cgCTL objects
* which can invoke the following methods:
* execute, unitSelected, studentSelected, checkGrade, enableChangeMarks, and saveGrade.
*/

/** Start of the class cgCTL */
public class cgCTL {
	cgUI CGUI; // Declare the object named CGUI of type cgUI 
	String cuc = null; // Declare and initialize the variable cuc to null 
	Integer currentStudentID = null; // Declare and initialize the variable currentStudentID to null 
	boolean changed = false; // Declare and initialize the variable changed to false 

	/** The no-args constructor for an object cgCTL */
	public cgCTL(){
	}

	/** Start of the method execute..... */
	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);
		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();
		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	} // End of the method execute 

	/** The method unitSelected.....*/
	public void unitSelected(String code) {
		if (code.equals("NONE"))
			CGUI.setState2(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	} // End of the method unitSelected

	/** Start of the method studentSelected....*/
	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}
		else {
			IStudent s = StudentManager.get().getStudent(id);
			IStudentUnitRecord r = s.getUnitRecord(cuc);
			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;
		}
	} // End of the method studentSelected

	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) {
			CGUI.setState6(true);
		}
		return s;
	}

	/** Start of the method enableChangeMarks....*/
	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	} // End of the method enableChangeMarks

	/** Start of the method saveGrade....*/
	public void saveGrade(float asg1, float asg2, float exam) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);
		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAsg1(asg1);
		r.setAsg2(asg2);
		r.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	} // End of the method saveGrade
} // End of the class cgCTL 
