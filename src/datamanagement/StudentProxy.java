/**
 * Specifying the name of the package in which the classes are
 */
package datamanagement;

/*
*@author Chiranjivi Bashyal
*@studentID: 11582726
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.3
 */

/*
*StudentProxy gets student ID, sirst name and last name
*sets the student ID, sirst name and last name
*and adds unit record, gets unit record and gets unit records
*/

public class StudentProxy implements IStudent { //StudentProxy implementing IStudent

    private Integer I; //integer I is private and can be changed into i
    private String l; //string l is private

    private String Il; //string Il is declared private and can be changed to il
    private StudentManager lI; //Student Manager lI is declared private

    public StudentProxy(Integer id, String fn, String Il) { //String Il can be changed to il //id, fn and Il are passed as arguments as integer, string and string respectively
        this.I = id; //id is passed to I
        this.l = fn; //fn is passed to I

        this.Il = Il; //Il is passed to Il
        this.lI = StudentManager.get(); //The value in StudentManager is passed to lI
    }

    public Integer getID() { //get the ID as an integer
        return I; //ID is set to be an integer

    }

    public String getFirstName() { //get the firstname as a string
        return l; //return the value of string of l
    }

    public String getLastName() {  //get the lastname as a string
        return Il; //return the value of string of Il
    }

    public void setFirstName(String firstName) { //set the firstname

        lI.getStudent(I).setFirstName(firstName); ////get the fn from I and set the firstname to lI
    }

    public void setLastName(String lastName) { //set the lastname

        lI.getStudent(I).setLastName(lastName); //get the fn from I and set the lastname to lI
    }

    public void addUnitRecord(IStudentUnitRecord record) { //method for passing IStudentUnitRecord as a record argument
        lI.getStudent(I).addUnitRecord(record); //pass the argument to lI
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) { //method for getting UnitRecord as a string i.e., unitcode

        return lI.getStudent(I).getUnitRecord(unitCode); //return the UnitRecord of lI passed to student I
    }

    public StudentUnitRecordList getUnitRecords() { //Get UnitRecords
        return lI.getStudent(I).getUnitRecords(); //returning the UnitRecords
    }
}
