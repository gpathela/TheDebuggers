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
 *          UnitProxy class implements IUnit . The main purpose of class is to
 *          get and set unitCode and unitNames. Appart from that it is also being
 *          used for get and set cutoff for each grade. It aslo set weightage
 *          for assesments items.
 *
 */

// Start of UnitProxy Class
public class UnitProxy implements IUnit {
	private String unitCode_; // Private variables of class
	private String unitName_;

	UnitManager unitManager;

	public UnitProxy(String unitCode, String unitName) { // Public Constructor
		this.unitCode_ = unitCode;
		this.unitName_ = unitName;
		unitManager = UnitManager.unitManager();
	}

	public String getUnitCode() { // Get method for UnitCode
		return this.unitCode_;
	}

	public String getUnitName() { // Get method for Unit Name
		return this.unitName_;
	}

	public void setPsCutoff(float psCutoff) { // Set method for setting cutoff
												// for Pass
		unitManager.getUnit(unitCode_).setPsCutoff(psCutoff);
	}

	public float getPsCutoff() { // Get cutoff for Pass Grade
		return unitManager.getUnit(unitCode_).getPsCutoff();
	}

	public void setCrCutoff(float crCutoff) { // Set method for setting cutoff
												// for Credit
		unitManager.getUnit(unitCode_).setCrCutoff(crCutoff);
	}

	public float getCrCutoff() { // Get cutoff for Credit Grade
		return unitManager.getUnit(unitCode_).getCrCutoff();
	}

	public void setDiCutoff(float diCutoff) { // Set method for setting cutoff
												// for Distiction
		unitManager.getUnit(unitCode_).setDiCutoff(diCutoff);
	}

	public float getDiCuttoff() { // Get cutoff for Distinction Grade
		return unitManager.getUnit(unitCode_).getDiCuttoff();
	}

	public void setHdCutoff(float hdCutoff) { // Set method for setting cutoff
												// for High Distinction
		unitManager.getUnit(unitCode_).setHdCutoff(hdCutoff);
	}

	public float getHdCutoff() { // Get cutoff for High Distinction Grade

		return unitManager.getUnit(unitCode_).getHdCutoff();
	}

	public void setAeCutoff(float aeCutoff) { // Set Ae cutoff
		unitManager.getUnit(unitCode_).setAeCutoff(aeCutoff);
	}

	public float getAeCutoff() { // Get Ae Cutoff
		return unitManager.getUnit(unitCode_).getAeCutoff();
	}

	public String getGrade(float f1, float f2, float f3) { // Geting grades of
															// students
		return unitManager.getUnit(unitCode_).getGrade(f1, f2, f3);
	}

	public void addStudentRecord(IStudentUnitRecord iStudentUnitRecord) { // Add
																			// student
																			// unit
																			// record
		unitManager.getUnit(unitCode_).addStudentRecord(iStudentUnitRecord);
	}

	public IStudentUnitRecord getStudentRecord(int studentRecord) { // Get
																	// student
																	// record
		return unitManager.getUnit(unitCode_).getStudentRecord(studentRecord);
	}

	public StudentUnitRecordList listStudentRecords() { // Lists student records
		return unitManager.getUnit(unitCode_).listStudentRecords();
	}

	public int getAsg1Weight() { // Get weightage for Assessment 1
		return unitManager.getUnit(unitCode_).getAsg1Weight();
	}

	public int getAsg2Weight() { // Get weightage for Assessment 2
		return unitManager.getUnit(unitCode_).getAsg2Weight();
	}

	public int getExamWeight() { // Get weightage for Assessment Exam
		return unitManager.getUnit(unitCode_).getExamWeight();
	}

	public void setAssessmentWeights(int asg1Weight, int asg2Weight, int examWeight) { // Set
																						// Weightage
																						// for
																						// Assessment
																						// items
																						// and
																						// Exam.
		unitManager.getUnit(unitCode_).setAssessmentWeights(asg1Weight, asg2Weight, examWeight);

	}
}
