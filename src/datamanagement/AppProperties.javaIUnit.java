/** Specify the package in which the classes are organized */
package datamanagement;

/**
*@author Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.2
*
*The IUnit contains a collection of abstract methods which allows other 
*classes to implement them. These methods get and set the following unit 
*attributes: code, name, grades, assignment and exam weights, student record 
*and the list of the all records.
*/

/** Start of the IUnit interface. The getter and setter methods with the off word should be changed to Off */
public interface IUnit {
    public String getUnitCode(); // Get the unit code
    public String getUnitName(); // Get the unit name 
    public float getPsCutoff(); // Get the pass cut off
	public float getCrCutoff(); // Get the credit cut off 
	public float getDiCuttoff(); // Get the distinction cut off 
	public float getHdCutoff(); // Get the high distinction cut off 
	public float getAeCutoff(); // Get the absence cut off 
	public int getAsg1Weight(); // Get assignment 1 weight 
    public int getAsg2Weight(); // Get assignment 2 weight 
    public int getExamWeight(); // Get the weight of the exam  
	public String getGrade(float asg1, float asg2, float exam); // Get the garde based on assignment 1, 2, and the marks of the exam 
	public IStudentUnitRecord getStudentRecord(int studentID ); // Get the student record 
	public StudentUnitRecordList listStudentRecords(); // List the student records 
	
    public void setPsCutoff1(float cutoff); // Set the pass cut off
    public void setCrCutoff(float cutoff); // Set the credit cut off
    public void setDiCutoff(float cutoff); // Set the distinction cut off 
	public void setHdCutoff(float cutoff); // Set the high distinction cut off     
    public void setAeCutoff(float cutoff); // Set the absence cut off  
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt); // Set the weights of the assessments  
    public void addStudentRecord(IStudentUnitRecord record ); // Add the student record 
} // End of IUnit interface
