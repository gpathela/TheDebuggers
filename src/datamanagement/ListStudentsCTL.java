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
* The ListStudentsCtl class is a program that uses private variables to create instances
* with a no-arg constructor.
*/

/** change class name from ListStudentsCTL to ListStudentsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListStudentsCtl {		//Start of the class ListStudentsCtl
  private StudentManager studentManager_;	// Private variables of class	
  /** Construst a default ListStudentsCtl object*/
  public ListStudentsCtl() {
	  studentManager_ = StudentManager.get();
	  }// End of the no-arg constructor
	  
  public void listStudents(IStudentLister studentLister, String unitCode) {
      studentLister.clearStudents();
      StudentMap students = studentManager_.getStudentsByUnit( unitCode );
      for (Integer id : students.keySet()) 
	  studentLister.addStudent(students.get(id));
      }
}//End of the class ListStudentsCtl
