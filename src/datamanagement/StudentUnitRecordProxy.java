/** Specify the package in which class resides */
package datamanagement;

/**
 * @reviewer Gourav Pathela
 * @course Master of Information Technology
 * @subject Professional Programming Practice
 * @lecturer Dr Recep Ulusoy
 * @due date 26.08.2016
 * @version 1.1
 * 
 */
public class StudentUnitRecordProxy implements IStudentUnitRecord {
	private Integer studentID;
	private String unitCode;
	private StudentUnitRecordManager mngr;

	public StudentUnitRecordProxy(Integer id, String code) {
		this.studentID = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordManager.instance();
	}

	public Integer getStudentID() {
		return studentID;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setAsg1(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
	}

	public float getAsg1() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg1();
	}

	public void setAsg2(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
	}

	public float getAsg2() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg2();
	}

	public void setExam(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setExam(mark);
	}

	public float getExam() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getExam();
	}

	public float getTotal() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
	}
}
