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
*The IStudent IStudentLister .......
*/

/** Start of the IStudentUnitRecord interface */
public interface IStudentUnitRecord {

    public Integer getStudentID();
    public String getUnitCode();

    public void setAsg1(float mark);
    public float getAsg1();

    public void setAsg2(float mark);
    public float getAsg2();

    public void setExam(float mark);
    public float getExam();

    public float getTotal();
} // End of IStudentUnitRecord interface