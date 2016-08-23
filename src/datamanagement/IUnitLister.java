/** Specify the package in which the class resides */
package datamanagement;

/**
* @reviewer Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @due date 26.08.2016
* @version 1.2
* 
* The IUnitLister Interface
*
*/

//Start of IUnitLister interface
public interface IUnitLister {

    public void clearUnits();		//implicitly abstract method
    public void addUnit(IUnit unit);	//implicitly abstract method

}//End of IUnitLister interface
