/** Specify the package in which the classes are organized */
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
* Start of Student class
*/

public class Student implements IStudent { // The student class implements IStudent
    private int id; 	// change datatype from Integer to int
	private String fn; //Declare First name to be an integer variable
    private String ln; // Declare Last name to be an integer variable
	private StudentUnitRecordList su;
	
	/** Construct an Student object with the specified attribute. */
	public Student(int id, String fn, String ln, StudentUnitRecordList su ){
		this.id = id; 
		this.fn = fn;
        this.ln = ln;
		this.su == null ? new StudentUnitRecordList() : su;
	}
	
	/** Return ID */
    public int getID(){ // Get the ID of a student
		return this.id; 
	} 
	
	/** Return First Name */
	public String getFirstName() { 
		return fn; 
	}

	/** Set a new First Name */
    public void setFirstName(String firstName){ 
		this.fn = firstName;
	}
	
	/** Return Last Name */
	public String getLastName(){ 
		return ln; 
	}
	
	/** Set a new Last Name */
    public void setLastName(String lastName){ 
		this.ln = lastName;
	}

	/** Set a new unit record*/
	public void addUnitRecord(IStudentUnitRecord record){
		su.add(record); 
	}
	
    public IStudentUnitRecord getUnitRecord(String unitCode){
		for (IStudentUnitRecord r : su) 
			if ( r.getUnitCode().equals(unitCode)) 
				return r; 

		return null;
        
	}

	public StudentUnitRecordList getUnitRecords(){ 
		return su; 
	}
}//End of student class
