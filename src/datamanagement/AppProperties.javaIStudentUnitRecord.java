/** Specify the package in which the classes are organized */
package datamanagement;

/**
*@author Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.4
*
*The IStudentUnitRecord contains a collection of abstract methods to allow
*other classes to implement them. These methods get and set the following
*student attributes: ID, unit code, the marks for assignment 1, 2, and 3, 
*the exam marks and the total of all the marks by using their getter methods.    
*/

/** Start of the IStudentUnitRecord interface */
public interface IStudentUnitRecord {

    public Integer getStudentID(); // Get the student ID 
    public String getUnitCode(); // Get the unit code 
	public float getAsg1(); // Get the mark for assignment 1 
	public float getAsg2(); // Get the mark for assignment 2
	public float getExam(); // Get the mark for the exam 
	public float getTotal(); // // Get the totla marks 

    public void setAsg1(float mark); // Set the mark for assignment 1
    public void setAsg2(float mark); // Set the mark for assignment 2
    public void setExam(float mark); // Set the mark for the exam 
} // End of IStudentUnitRecord interface
