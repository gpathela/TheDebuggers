/** Displaying the package in which the classes are organized */
package datamanagement;

/**
*@author Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.3
*
* The class cgCTL, originally, was renamed to CgCtl to comply to the Java conventions.
* It allows the instantiation of CgCtl objects which can invoke the following methods:
* execute(), unitSelected(), studentSelected(), checkGrade(), enableChangeMarks(), and saveGrade().
*/

/** Start of the class CgCtl */
public class CgCtl {
	/** Declare and initialize the variable for the class */
	CgUI cgUI; // Declare the variable named cgUI of type CgUI 
	String cuc = null; // Declare and initialize the variable cuc to null 
	Integer currentStudentID = null; // Declare and initialize the variable currentStudentID of type Integer to null 
	boolean changed = false; // Declare and initialize the variable changed, of type boolean, to false 

	/** The no-args constructor for an object CgCtl */
	public CgCtl(){
	}

	/** Start of the method execute which creates a new object of type CgUI
		and sets it to different states. It then creates an action event object 
		which is used to invoke some methods */
	public void execute() {
		cgUI = new CgUI(this);
		cgUI.setState1(false);
		cgUI.setState2(false);
		cgUI.setState3(false);
		cgUI.setState4(false);
		cgUI.setState5(false);
		cgUI.setState6(false);
		cgUI.Refresh3(); // Refresh the object cgUI
		ListUnitsCTL luCTL = new ListUnitsCTL(); // Declare the variable luCTL of type ListUnitsCTL
		luCTL.listUnits(cgUI); // The variable luCTL invokes the method listUnits with a parameter of cgUI
		cgUI.setVisible(true); // Set cgUI to visible
		cgUI.setState1(true); // Set the state1 of cgUI to true 
	} // End of the method execute 

	/** The method unitSelected  selects a unit under certain conditions.
		It then invokes a method to list the units based on the list of 
		students in relation to their code */
	public void unitSelected(String code) {
		if(code.equals("NONE")) // Test the condition that the code is non existant
			cgUI.setState2(false);
		else{
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(cgUI, code);
			cuc = code;
			cgUI.setState2(true);
		}
		cgUI.setState3(false);
	} // End of the method unitSelected

	/** Start of the method studentSelected which selects the current studentSelected
		based on their ID under some conditions. */
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

	/** Start of the checkGrade method which returns a message of type string
		when the grade of a student is checked */
	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		cgUI.setState4(true);
		cgUI.setState5(false);
		if(changed){
			cgUI.setState6(true);
		}
		return s;
	} // End of the checkGrade method 

	/** Start of the method enableChangeMarks which allows the user to change the marks of a student */
	public void enableChangeMarks() {
		cgUI.setState4(false);
		cgUI.setState6(false);
		cgUI.setState5(true);
		changed = true;
	} // End of the method enableChangeMarks

	/** Start of the method saveGrade which allows the user to save the grade of a student based on a 
		parameter of variables of type float */
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
} // End of the class CgCTL 
