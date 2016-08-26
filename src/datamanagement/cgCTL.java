/** Displaying the package in which the classes are organized */
package datamanagement;

/**
*@author Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.4
*
* The class cgCTL, originally, was renamed to CgCtl to comply to the Java conventions.
* It allows the instantiation of CgCtl objects which can invoke the following methods:
* execute(), unitSelected(), studentSelected(), checkGrade(), enableChangeMarks(), and saveGrade().
* Changes to be made to this class: class name cgCTL to CgCtl, variable name CGUI to cGUI.
*/

/** Start of the class CgCtl */
public class cgCTL  {
	/** Declare and initialize the variable for the class */
	cgUI  CGUI; // Declare the variable named cgUI of type CgUI 
	String cuc = null; // Declare and initialize the variable cuc to null 
	Integer currentStudentID = null; // Declare and initialize the variable currentStudentID of type Integer to null 
	boolean changed = false; // Declare and initialize the variable changed, of type boolean, to false 

	/** The no-args constructor for an object should be CgCtl not cgCTL*/
	public cgCTL(){
	}

	/** Start of the method execute which creates a new object of type CgUI
		and sets it to different states. It then creates an action event object 
		which is used to invoke some methods */
	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);
		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3(); // Refresh the object cgUI
		ListUnitsCTL luCTL = new ListUnitsCTL(); // Declare the variable luCTL of type ListUnitsCTL
		luCTL.listUnits(CGUI); // The variable luCTL invokes the method listUnits with a parameter of cgUI
		CGUI.setVisible(true); // Set cgUI to visible
		CGUI.setState1(true); // Set the state1 of cgUI to true 
	} // End of the method execute 

	/** The method unitSelected  selects a unit under certain conditions.
		It then invokes a method to list the units based on the list of 
		students in relation to their code */
	public void unitSelected(String code) {
		if(code.equals("NONE")) // Test the condition that the code is non existant
			CGUI.setState2(false);
		else{
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	} // End of the method unitSelected

	/** Start of the method studentSelected which selects the current studentSelected
		based on their ID under some conditions. */
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

	/** Start of the checkGrade method which returns a message of type string
		when the grade of a student is checked */
	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if(changed){
			CGUI.setState6(true);
		}
		return s;
	} // End of the checkGrade method 

	/** Start of the method enableChangeMarks which allows the user to change the marks
		of a student using an instance of the class CGUI */
	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
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
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	} // End of the method saveGrade
} // End of the class cgCTL
