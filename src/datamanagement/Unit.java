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
 *          Unit class implements IUnit . The main purpose of class is to get
 *          marks and set the grades of the students. It set values for cutoff
 *          for each grade and then total marks and compare marks to grades and
 *          set the grades.
 *
 */

// Start of Unit Class

public class Unit implements IUnit {
	private String uc; // Private variables of Class. According to java
						// convention they need to changed to something
						// meaningfull.
	private String UN;
	private float co2;
	private float co1;
	private float co4;
	private float co3;
	private float co5;
	private int a1, a2, ex;

	private StudentUnitRecordList rs;

	public Unit(String UC, String un, float f1, float f2, float f3, float f4, float f5, int i1, int i2, int i3,
			StudentUnitRecordList rl) { // Public Constructor. Variables need to
										// be changed according to java
										// convention

		uc = UC;
		UN = un;
		co2 = f1;
		co1 = f2;
		this.co4 = f3;
		co3 = f4;
		this.co5 = f5;
		this.setAssessmentWeights(i1, i2, i3);
		rs = rl == null ? new StudentUnitRecordList() : rl;
	}

	public String getUnitCode() { // Method to get Unit Code
		return this.uc;
	}

	public String getUnitName() { // Method to get Unit Name

		return this.UN;
	}

	public void setPsCutoff1(float cutoff) { // Method to set Ps cut off. Name
												// should be changed.
		this.co2 = cutoff;
	}

	public float getPsCutoff() { // Method to get Ps Cutoff
		return this.co2;
	}

	public void setCrCutoff(float cutoff) { // Method to set Cr Cutoff
		this.co1 = cutoff;
	}

	public float getCrCutoff() { // Method to get Cr cutoff
		return this.co1;
	}

	public void setDiCutoff(float cutoff) { // Method to set Di Cutoff
		this.co4 = cutoff;
	}

	public float getDiCuttoff() { // Method to get Di Cutoff
		return this.co4;
	}

	public void HDCutoff(float cutoff) { // This is a redundent Method
		this.co3 = cutoff;
	}

	public void setHdCutoff(float cutoff) { // Method to set HD Cutoff
		this.co3 = cutoff;
	}

	public float getHdCutoff() { // Method to get Hd Cutoff
		return this.co3;

	}

	public void setAeCutoff(float cutoff) { // Method to set Ae Cutoff
		this.co5 = cutoff;
	}

	public float getAeCutoff() { // Method to get Ae Cutoff
		return this.co5;
	}

	public void addStudentRecord(IStudentUnitRecord record) { // Method to add
																// Student Code
		rs.add(record);
	}

	public IStudentUnitRecord getStudentRecord(int studentID) { // Method to get
																// Student
																// Record
		for (IStudentUnitRecord r : rs) {
			if (r.getStudentID() == studentID)
				return r;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() { // Method to get Student
														// List
		return rs;
	}

	@Override
	public int getAsg1Weight() { // Method to get Asg 1 Weight
		return a1;
	}

	@Override
	public int getAsg2Weight() { // Method to get Asg 2 Weight
		return a2;
	}

	@Override
	public int getExamWeight() { // Method to get exam Weight
		return ex;
	}

	@Override
	public void setAssessmentWeights(int a1, int a2, int ex) { // Method to set
																// Asg Weights
		if (a1 < 0 || a1 > 100 || a2 < 0 || a2 > 100 || ex < 0 || ex > 100) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}
		if (a1 + a2 + ex != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.a1 = a1;
		this.a2 = a2;
		this.ex = ex;
	}

	private void setCutoffs(float ps, float cr, float di, float hd, float ae) { // Method
																				// to
																				// set
																				// Cutoffs
		if (ps < 0 || ps > 100 || cr < 0 || cr > 100 || di < 0 || di > 100 || hd < 0 || hd > 100 || ae < 0
				|| ae > 100) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (ae >= ps) {
			throw new RuntimeException("AE cutoff must be less than PS cutoff");
		}
		if (ps >= cr) {
			throw new RuntimeException("PS cutoff must be less than CR cutoff");
		}
		if (cr >= di) {
			throw new RuntimeException("CR cutoff must be less than DI cutoff");
		}
		if (di >= hd) {
			throw new RuntimeException("DI cutoff must be less than HD cutoff");
		}

	} // End of method to set Cutoffs

	public String getGrade(float f1, float f2, float f3) { // Method to get
															// Grade
		float t = f1 + f2 + f3;

		if (f1 < 0 || f1 > a1 || f2 < 0 || f2 > a2 || f3 < 0 || f3 > ex) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (t < co5) {
			return "FL";
		} else if (t < co2)
			return "AE";
		else if (t < co1)
			return "PS";
		else if (t < co4)
			return "CR";
		else if (t < co3)
			return "DI";
		else
			return "HD";
	} // End of Method get Gades

}