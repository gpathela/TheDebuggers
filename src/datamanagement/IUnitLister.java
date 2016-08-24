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
* The IUnitLister Interface contains a collection of abstract methods 
* to allow other classes to implement them. These methods can clear  
* or add student objects to a list. 
*
*/

//Start of IUnitLister interface
public interface IUnitLister {

    public void clearUnits();		//Clear units from the list
    public void addUnit(IUnit unit);	//Add IUnit objects to the list 

}//End of IUnitLister interface
