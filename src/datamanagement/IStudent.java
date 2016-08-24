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
*The IStudent interface contains a collection of abstract methods 
*to allow other class to implement them. These methods can provide 
*or set the first and last name of a student, as well as adding a 
*the created record to a list of student.
*/

/** Start of the IStudent interface */
public interface IStudent {

    public Integer getID(); // Get the ID of a student 
    public String getFirstName(); // Get the first name of a student
    public String getLastName(); // Get the last name of a student 
	
	public void setFirstName(String firstName); // Set the first name of a student
    public void setLastName(String lastName); // Set the last name of a student 
    
	public void addUnitRecord(IStudentUnitRecord record); // Add the unit of a particular student to a record 
    public IStudentUnitRecord getUnitRecord(String unitCode); // Get the unit record of a student based on the unit code 
    public StudentUnitRecordList getUnitRecords(); // Get the list of all the recorded units 
} // End of the IStudent interface 
