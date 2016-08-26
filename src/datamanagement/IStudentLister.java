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
*The IStudentLister contains a collection of abstract methods 
*to allow other classes to implement them. These methods can clear  
*or add student objects to a list. 
*/ 
 
/** Start of the IStudentLister interface */
public interface IStudentLister{
    public void clearStudents(); // Clear student from the list 
    public void addStudent(IStudent student); // Add IStudent objects to the list 
} // End of the IStudentLister interface 
