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
* The ListStudentsCTL class is a program that uses private variables to create instances
* with a no-arg constructor.
*/

/** need to change the class name from ListStudentsCTL to ListStudentsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListStudentsCTL {		//Start of the class ListStudentsCTL
  private StudentManager studentManager_;	// change the private variables of class from sm to studentManager_	
  /** Construst a default ListStudentsCTL object*/
  public ListStudentsCTL() {
	  studentManager_ = StudentManager.get();
	  }// End of the no-arg constructor
	  
  public void listStudents(IStudentLister lister, String unitCode) {
      lister.clearStudents();
      StudentMap students = studentManager_.getStudentsByUnit( unitCode );
      for (Integer id : students.keySet()) 
	  lister.addStudent(students.get(id));
      }
}//End of the class ListStudentsCTL
