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
	private String unitCode_; // Private variables of class
	private String unitName_;
	private float psCutoff_;
	private float crCutoff_;
	private float diCutoff_;
	private float hdCutoff_;
	private float aeCutoff_;
	private int asg1Weight_, asg2Weight_, examWeight_;

	private StudentUnitRecordList recordList_;

	public Unit(String unitCode, String unitName, float psCutoff, float crCutoff, float diCutoff, float hdCutoff,
			float aeCutoff, int asg1Weight, int asg2Weight, int examWeight, StudentUnitRecordList recordList) { // Public
																												// constructor
																												// of
																												// the
																												// class/

		unitCode_ = unitCode;
		unitName_ = unitName;
		psCutoff_ = psCutoff;
		crCutoff_ = crCutoff;
		diCutoff_ = diCutoff;
		hdCutoff_ = hdCutoff;
		aeCutoff_ = aeCutoff;
		this.setAssessmentWeights(asg1Weight, asg2Weight, examWeight);
		recordList_ = recordList == null ? new StudentUnitRecordList() : recordList;
	}

	public String getUnitCode() { // Method to get unitCode
		return this.unitCode;
	}

	public String getUnitName() { // Method to get unitName

		return this.unitName;
	}

	public void setPsCutoff(float psCutoff) { // Method to set Ps Cutoff
		this.psCutoff_ = psCutoff;
	}

	public float getPsCutoff() { // Method to Get Ps Cutoff
		return this.psCutoff_;
	}

	public void setCrCutoff(float crCutoff) { // Method to set Cr Cutoff
		this.crCutoff_ = crCutoff;
	}

	public float getCrCutoff() { // Method to get Cr Cutoff
		return this.crCutoff_;
	}

	public void setDiCutoff(float diCutoff) { // Method to set Di Cutoff
		this.diCutoff_ = diCutoff;
	}

	public float getDiCuttoff() { // Method to get Di Cutoff
		return this.diCutoff_;
	}

	// Repeat so Commenting Out
	// public void setHdCutoff(float cutoff) {
	// this.co3 = cutoff;
	// }

	public void setHdCutoff(float hdCutoff) { // Method to set Hd Cutoff
		this.hdCutoff_ = hdCutoff;
	}

	public float getHdCutoff() { // Method to get Hd Cutoff
		return this.hdCutoff_;

	}

	public void setAeCutoff(float aeCutoff) { // Method to set Ae Cutoff
		this.aeCutoff_ = aeCutoff;
	}

	public float getAeCutoff() { // Method to get Ae Cutoff
		return this.aeCutoff_;
	}

	public void addStudentRecord(IStudentUnitRecord studentRecord) { // Method
																		// to
																		// add
																		// student
																		// record
		recordList_.add(studentRecord);
	}

	public IStudentUnitRecord getStudentRecord(int studentId) { // Method to get
																// student
																// record
		for (IStudentUnitRecord studentRecord : recordList_) {
			if (studentRecord.getStudentId() == studentId)
				return studentRecord;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() { // Method to get student
														// record list
		return recordList_;
	}

	@Override
	public int getAsg1Weight() { // Method to get Asg1 Weight
		return asg1Weight_;
	}

	@Override
	public int getAsg2Weight() { // Method to get Asg2 Weight
		return asg2Weight_;
	}

	@Override
	public int getExamWeight() { // Method to get exam Weight
		return examWeight_;
	}

	@Override
	public void setAssessmentWeights(int asg1Weight, int asg2Weight, int examWeight) { // Method
																						// to
																						// set
																						// Weight
																						// of
																						// asignments
																						// and
																						// exam
		if (asg1Weight < 0 || asg1Weight > 100 || asg2Weight < 0 || asg2Weight > 100 || examWeight < 0
				|| examWeight > 100) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}
		if (asg1Weight + asg2Weight + examWeight != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.asg1Weight_ = asg1Weight;
		this.asg2Weight_ = asg2Weight;
		this.examWeight_ = examWeight;
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

	}

	public String getGrade(float asg1Mark, float asg2Mark, float examMark) { // Method
																				// to
																				// get
																				// Grades
		float total = asg1Mark + asg2Mark + examMar;

		if (asg1Mark < 0 || asg1Mark > asg1Weight_ || asg2Mark < 0 || asg2Mark > asg2Weight_ || examMark < 0
				|| examMark > examWeight_) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (total < aeCutoff_) {
			return "FL";
		} else if (total < psCutoff_)
			return "AE";
		else if (total < crCutoff_)
			return "PS";
		else if (total < diCutoff_)
			return "CR";
		else if (total < hdCutoff_)
			return "DI";
		else
			return "HD";
	}

}