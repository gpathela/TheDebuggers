/** 
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @date 20.08.2016
*/
package datamanagement;

/** change class name from ListStudentsCTL to ListStudentsCtl 
* as abbreviations and acronyms should not be uppercase
*/
public class ListStudentsCtl {		//Start of the class
  private StudentManager sm;		
  /** Construst a default ListStudentsCtl object*/
  public ListStudentsCtl() {
	  sm = StudentManager.get();
	  }
  public void listStudents(IStudentLister lister, String unitCode) {
      lister.clearStudents();
      StudentMap students = sm.getStudentsByUnit( unitCode );
      for (Integer id : students.keySet()) 
	  lister.addStudent(students.get(id));
      }
}//End of the class
