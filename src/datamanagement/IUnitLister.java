/** Specify the package in which the class resides */
package datamanagement;

/**
*@reviewer Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.2
*
*The IUnitLister interface has two methods, clearUnits and addUnit,
*which add and clear units from the user interface.
*/

/** Start of the interface IUnitLister */
public interface IUnitLister {
    public void clearUnits();
    public void addUnit(IUnit unit);
} // End of the interface IUnitLister