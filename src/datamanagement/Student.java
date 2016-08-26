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
* Start of Student class. The main purpose of this class is to get or set the name, ID and unit record of the student.need to make some changes 
* in the variable name as from fn to firstName, ln to lastName and su to studentUnit.
*/

public class Student implements IStudent { // The Student class implements IStudent
    private Integer id; 	
	private String fn; //Declare First name to be an integer variable. variable should be firstName instead of fn
    private String ln; // Declare Last name to be an integer variable. variable should be lastName instead of ln
	private StudentUnitRecordList su; //variable should be studentUnit instead of su
	
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
    public void setFirstName(String fn){ 
		this.fn = fn;
	}
	
	/** Return Last Name */
	public String getLastName(){ 
		return ln; 
	}
	
	/** Set a new Last Name */
    public void setLastName(String ln){ 
		this.ln = ln;
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
}//End of Student class
