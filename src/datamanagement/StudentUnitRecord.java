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
*
*/

public class StudentUnitRecord implements IStudentUnitRecord {

    private Integer sid; //sid can be changed to studentId //sid is declared as a private integer
    private String uc; //uc can be changed to unitCode //uc is declared as a private string
    private float a1, a2, ex; //a1, a2 and ex are declared as private floating points               

    public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) { //sets the parameters for StudentUnitRecord
        this.sid = id; //id is passed to sid
        this.uc = code; //code is passed to uc
        this.setAsg1(asg1); //asg1 is set to Asg1
        this.setAsg2(asg2); //asg2 is set to Asg2
        this.setExam(exam); //exam is set ti Exam
    }

    public Integer getStudentID() { //method for getStudentID
        return sid; //returns the StudentID
    }

    public String getUnitCode() { //method for getting UnitCode
        return uc; //returns the UnitCode
    }

    public void setAsg1(float a1) { //a1 as an floating point argument for setAsg1
        if (a1 < 0 || a1 > UnitManager.UM().getUnit(uc).getAsg1Weight()) { //condition checking if a1<0 or a1>UnitManager.UM().getUnit(uc).getAsg1Weight()
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight"); //throws a RunTimeException
        }
        this.a1 = a1; //sets a1 to a1
    }

    public float getAsg1() { //method for getAsg1
        return a1; //returns the value of a1
    }

    public void setAsg2(float a2) { //a2 as an floating point argument for setAsg2
        if (a2 < 0 || a2 > UnitManager.UM().getUnit(uc).getAsg2Weight()) { //checking condition if (a2 < 0 || a2 > UnitManager.UM().getUnit(uc).getAsg2Weight())
            /**
             * Exception Handling
             */
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.a2 = a2; //assigns a2 to a2

    }

    public float getAsg2() { //method for getAsg2
        return a2; //returns the value of a2
    }

    public void setExam(float ex) {
        ex as an floating point argument for setExam {
            if (ex < 0 || ex > UnitManager.UM().getUnit(uc).getExamWeight()) { //checking condition if (ex < 0 || ex > UnitManager.UM().getUnit(uc).getExamWeight())
                /**
                 * Exception Handling
                 */
                throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
            }
        }
        this.ex = ex; //assigns ex to ex
    }

    public float getExam() { //method for getExam
        return ex; //returns the value of ex
    }

    public float getTotal() { //method for getTotal
        return a1 + a2 + ex; //returns the value of (a1 + a2 + ex)
    }
}
