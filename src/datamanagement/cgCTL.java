/** Displaying the package in which the class resides */
package datamanagement;
/**
* This class allows the instantiation of CgCtl objects
* which can invoke the following methods:
* execute, unitSelected, studentSelected, checkGrade, enableChangeMarks, and saveGrade.
*/

/** Start of the class CgCtl. The class name should start with a capital letter. 
	Following the Java convention, the desired class name would be as follows CgCtl */
public class CgCtl {
	CgUI cgUI; // Declare the object named CGUI of type cgUI 
	String cuc = null; // Declare and initialize the variable cuc to null 
	Integer currentStudentID = null; // Declare and initialize the variable currentStudentID to null 
	boolean changed = false; // Declare and initialize the variable changed to false 

	/** The no-args constructor for an object CgCtl */
	public CgCtl(){
	}

	/** Start of the method execute..... */
	public void execute() {
		cgUI = new CgUI(this);
		cgUI.setState1(false);
		cgUI.setState2(false);
		cgUI.setState3(false);
		cgUI.setState4(false);
		cgUI.setState5(false);
		cgUI.setState6(false);
		cgUI.Refresh3();
		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(cgUI);
		cgUI.setVisible(true);
		cgUI.setState1(true);
	} // End of the method execute 

	/** The method unitSelected.....*/
	public void unitSelected(String code) {
		if (code.equals("NONE"))
			cgUI.setState2(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(cgUI, code);
			cuc = code;
			cgUI.setState2(true);
		}
		cgUI.setState3(false);
	} // End of the method unitSelected

	/** Start of the method studentSelected....*/
	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			cgUI.Refresh3();
			cgUI.setState3(false);
			cgUI.setState4(false);
			cgUI.setState5(false);
			cgUI.setState6(false);
		}
		else {
			IStudent s = StudentManager.get().getStudent(id);
			IStudentUnitRecord r = s.getUnitRecord(cuc);
			cgUI.setRecord(r);
			cgUI.setState3(true);
			cgUI.setState4(true);
			cgUI.setState5(false);
			cgUI.setState6(false);
			changed = false;
		}
	} // End of the method studentSelected

	/** Start of the checkGrade method */
	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		cgUI.setState4(true);
		cgUI.setState5(false);
		if (changed) {
			cgUI.setState6(true);
		}
		return s;
	} // End of the checkGrade method 

	/** Start of the method enableChangeMarks....*/
	public void enableChangeMarks() {
		cgUI.setState4(false);
		cgUI.setState6(false);
		cgUI.setState5(true);
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
		cgUI.setState4(true);
		cgUI.setState5(false);
		cgUI.setState6(false);
	} // End of the method saveGrade
} // End of the class cgCTL 
