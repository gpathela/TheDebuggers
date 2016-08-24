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
	private Integer studentId_; // Class Private Variables
	private String unitCode_;
	private StudentUnitRecordManager studentUnitRecordManager_;

	public StudentUnitRecordProxy(Integer studentId, String unitCode) { // Public
																		// Constructor
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.studentUnitRecordManager_ = StudentUnitRecordManager.instance();
	}

	public Integer getStudentId() { // Method to get student Id
		return studentId_;
	} // End of method to get Student Id

	public String getUnitCode() { // Method to get Unit Code
		return unitCode_;
	} // End of method to get unitCode

	public void setAsg1(float mark) { // Method to set marks of assignment 1
		studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
	}

	public float getAsg1() { // Method to get marks of assignment 1
		return studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).getAsg1();
	}

	public void setAsg2(float mark) { // Method to set marks of assignment 2
		studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
	}

	public float getAsg2() { // Method to get marks of assignment 2
		return studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).getAsg2();
	}

	public void setExam(float mark) { // Method to set marks of exam
		studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).setExam(mark);
	}

	public float getExam() { // Method to get marks of exam
		return studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).getExam();
	}

	public float getTotal() { // Method to get total marks
		return studentUnitRecordManager_.getStudentUnitRecord(studentID, unitCode).getTotal();
	}
}
