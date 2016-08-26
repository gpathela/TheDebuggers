/** Specify the package in which class resides */
package datamanagement;

/**
 * @reviewer Gourav Pathela
 * @course Master of Information Technology
 * @subject Professional Programming Practice
 * @lecturer Dr Recep Ulusoy
 * @due date 26.08.2016
 * @version 1.3
 * 
 *          StudentUnitRecordProxy class implements IStudentUnitRecord . The
 *          main purpose of class is to get and set marks of assesments and
 *          exams.
 *
 */

// Start of StudentUnitRecordProxy Class
public class StudentUnitRecordProxy implements IStudentUnitRecord {
	private Integer studentID; // Private variables. According to Convention we
								// can add _ in the end
	private String unitCode;
	private StudentUnitRecordManager mngr;

	public StudentUnitRecordProxy(Integer id, String code) { // Public
																// Constructor
		this.studentID = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordManager.instance();
	} // End of Constructor

	public Integer getStudentID() { // Method to get Student Id
		return studentID;
	} // End of method to get student Id

	public String getUnitCode() { // Method to get Unit Code
		return unitCode;
	} // End of method to get Unit Code

	public void setAsg1(float mark) { // Method to set Marks of Assignment 1
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
	} // End of Method to set Marks of Assignment 1

	public float getAsg1() { // Method to get Marks of Assignment 1
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg1();
	} // End of Method to get Marks of Assignment 1

	public void setAsg2(float mark) { // Method to set Marks of Assignment 2
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
	} // End of Method to set Marks of Assignment 2

	public float getAsg2() { // Method to get Marks of Assignment 2
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg2();
	} // Method to get Marks of Assignment 2

	public void setExam(float mark) { // Method to set Marks of Exam
		mngr.getStudentUnitRecord(studentID, unitCode).setExam(mark);
	} // End of Method to set Marks of Exam

	public float getExam() { // Method to get Marks of Exam
		return mngr.getStudentUnitRecord(studentID, unitCode).getExam();
	} // End of Method to get Marks of Exam

	public float getTotal() { // Method to get Total Marks
		return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
	} // End of Method to get Total Marks
}
