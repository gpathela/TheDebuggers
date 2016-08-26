/** Specify the package in which the classes resides */
package datamanagement;

/**
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 26.08.2016
* @version 1.3
* 
*
* Start of Student class. The main purpose of this class is to get or set the name, ID and unit record of the student. I made some changes 
* in the variable name as from fn to firstName, ln to lastName and su to studentUnit.
*/

public class Student implements IStudent { // The student class implements IStudent
    private int id; 	// change datatype from Integer to int
	private String firstName; //Declare First name to be an integer variable
    private String lastName; // Declare Last name to be an integer variable
	private StudentUnitRecordList studentUnit;
	
	/** Construct an Student object with the specified attribute. */
	public Student(int id, String firstName, String lastName, StudentUnitRecordList studentUnit ){
		this.id = id; 
		this.firstName = firstName;
        this.lastName = lastName;
		this.studentUnit == null ? new StudentUnitRecordList() : studentUnit;
	}
	
	/** Return ID */
    public int getID(){ // Get the ID of a student
		return this.id; 
	} 
	
	/** Return First Name */
	public String getFirstName() { 
		return firstName; 
	}

	/** Set a new First Name */
    public void setFirstName(String firstName){ 
		this.firstName = firstName;
	}
	
	/** Return Last Name */
	public String getLastName(){ 
		return lastName; 
	}
	
	/** Set a new Last Name */
    public void setLastName(String lastName){ 
		this.lastName = lastName;
	}

	/** Set a new unit record*/
	public void addUnitRecord(IStudentUnitRecord record){
		studentUnit.add(record); 
	}
	
    public IStudentUnitRecord getUnitRecord(String unitCode){
		for (IStudentUnitRecord r : studentUnit) 
			if ( r.getUnitCode().equals(unitCode)) 
				return r; 

		return null;
        
	}

	public StudentUnitRecordList getUnitRecords(){ 
		return studentUnit; 
	}
}//End of student class
