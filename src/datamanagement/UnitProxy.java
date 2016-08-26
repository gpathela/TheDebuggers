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
 *          get and set unitCode and unitNames. Appart from that it is also
 *          being used for get and set cutoff for each grade. It aslo set
 *          weightage for assesments items.
 *
 */

// Start of UnitProxy Class
public class UnitProxy implements IUnit {
	private String UC; // Private variabels of class. Should be more intutive
						// and shall end with _
	private String un;

	UnitManager um;

	public UnitProxy(String unitCode, String unitName) { // Public Constructor
		this.UC = unitCode;
		this.un = unitName;
		um = UnitManager.UM();
	}

	public String getUnitCode() { // Method to get Unit Code
		return this.UC;
	}

	public String getUnitName() { // Method to get Unit Name
		return this.un;
	}

	public void setPsCutoff1(float cutoff) { // Method to set Ps Cutoff
		um.getUnit(UC).setPsCutoff1(cutoff);
	}

	public float getPsCutoff() { // Method to get Ps Cutoff
		return um.getUnit(UC).getPsCutoff();
	}

	public void setCrCutoff(float cutoff) { // Method to set Cr Cutoff
		um.getUnit(UC).setCrCutoff(cutoff);
	}

	public float getCrCutoff() { // Method to Get Cr Cutoff
		return um.getUnit(UC).getCrCutoff();
	}

	public void setDiCutoff(float cutoff) { // Method to Set Di Cutoff
		um.getUnit(UC).setDiCutoff(cutoff);
	}

	public float getDiCuttoff() { // Method to get Di Cutoff
		return um.getUnit(UC).getDiCuttoff();
	}

	public void setHdCutoff(float cutoff) { // Method to set Hd
		um.getUnit(UC).setHdCutoff(cutoff);
	}

	public float getHdCutoff() { // Method to get HD

		return um.getUnit(UC).getHdCutoff();
	}

	public void setAeCutoff(float cutoff) { // Method to set Ae Cutoff
		um.getUnit(UC).setAeCutoff(cutoff);
	}

	public float getAeCutoff() { // Method to get Ae cutoff
		return um.getUnit(UC).getAeCutoff();
	}

	public String getGrade(float f1, float f2, float f3) { // Method to get
															// Grades
		return um.getUnit(UC).getGrade(f1, f2, f3);
	}

	public void addStudentRecord(IStudentUnitRecord record) { // Method to add
																// student
																// Record
		um.getUnit(UC).addStudentRecord(record);
	}

	public IStudentUnitRecord getStudentRecord(int s) { // Method to get Student
														// Record
		return um.getUnit(UC).getStudentRecord(s);
	}

	public StudentUnitRecordList listStudentRecords() { // Method to list
														// Student Records
		return um.getUnit(UC).listStudentRecords();
	}

	public int getAsg1Weight() { // Method to get Weight for Asg 1
		return um.getUnit(UC).getAsg1Weight();
	}

	public int getAsg2Weight() { // Method to get weight for Asg 2
		return um.getUnit(UC).getAsg2Weight();
	}

	public int getExamWeight() { // Method to get Exam Weight
		return um.getUnit(UC).getExamWeight();
	}

	public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) { // Method
																				// to
																				// set
																				// Assessment
																				// Weights
		um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);

	}
}
