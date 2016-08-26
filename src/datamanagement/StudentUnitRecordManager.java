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
*StudentUnitRecordManager creates an instance
*gets StudentUnitRecord, creates StudentUnitRecord and saves it
*/

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager { //creating class StudentUnitRecordManager

    private static StudentUnitRecordManager s = null; //null value for s in StudentUnitRecordManager
    private StudentUnitRecordMap rm; //rm can be changed to recordMap //declaring StudentUnitRecordMap with rm as private
    private java.util.HashMap<String, StudentUnitRecordList> ur; //ur can be changed to unitRecordList //declaring java.util.HashMap<String,StudentUnitRecordList> with ur as private
    private java.util.HashMap<Integer, StudentUnitRecordList> sr; //sr can be changed to studentUnitRecordListdeclaring java.util.HashMap<Integer,StudentUnitRecordList> with sr as private

    public static StudentUnitRecordManager instance() { //creating an instance of StudentUnitRecordManager
        if (s == null) {
            s = new StudentUnitRecordManager(); //condition checking if (s == null ) s = new StudentUnitRecordManager()
        }
        return s; ////returns the value of s
    }

    private StudentUnitRecordManager() { //declaring StudentUnitRecordManager as private
        rm = new StudentUnitRecordMap(); //new StudentUnitRecordMap is passed to rm
        ur = new java.util.HashMap<>(); //new java.util.HashMap<>() is passed to ur
        sr = new java.util.HashMap<>(); //new java.util.HashMap<>() is passed to sr
    }

    /**
     * Get method for getStudentUnitRecord
     */
    public IStudentUnitRecord getStudentUnitRecord(Integer studentID, String unitCode) {  //passing arguments studentID as an integer and unitCode as a string
        IStudentUnitRecord ir = rm.get(studentID.toString() + unitCode);
        return ir != null ? ir : createStudentUnitRecord(studentID, unitCode); //checking condition and creating StudentUnitRecord
    }

    /**
     * creating IStudentUnitRecord as a private with uid and sid as integer and
     * string respectively
     */
    private IStudentUnitRecord createStudentUnitRecord(Integer uid, String sid) {
        IStudentUnitRecord ir; //passing ir to IStudentUnitRecord
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) { //for loop
            if (uid.toString().equals(el.getAttributeValue("sid")) && sid.equals(el.getAttributeValue("uid"))) { //condition checking
                ir = new StudentUnitRecord(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid"), new Float(el.getAttributeValue("asg1")).floatValue(), new Float(el.getAttributeValue("asg2")).floatValue(), new Float(el.getAttributeValue("exam")).floatValue());
                rm.put(ir.getStudentID().toString() + ir.getUnitCode(), ir);
                return ir; //return the vlue of ir
            }
        }
        /**
         * Exception handling
         */
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }

    public StudentUnitRecordList getRecordsByUnit(String unitCode) { //getting RecordsByUnit as string unitcode
        StudentUnitRecordList recs = ur.get(unitCode); //get the unitcode and pass to recs
        if (recs != null) { //checking condition and returning recs
            return recs; //returns the value of recs
        }
        recs = new StudentUnitRecordList(); //creating new StudentUnitRecordList()
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) { //for loop
            if (unitCode.equals(el.getAttributeValue("uid"))) {
                recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid"))); //checking condition
            }
        }
        if (recs.size() > 0) //condition checking if ( recs.size() > 0 ){
        {
            ur.put(unitCode, recs); // be careful - this could be empty
        }
    }
    return recs ; //return the value of recs
} //End of StudentUnitRecordManager

public StudentUnitRecordList getRecordsByStudent(Integer studentID) { //getting RecordsByStudent as integer studentID
        StudentUnitRecordList recs = sr.get(studentID); //get the studentID and pass to recs
        if (recs != null) {
            return recs; //checking condition and returning recs
        }
        recs = new StudentUnitRecordList(); //creating new StudentUnitRecordList()
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) { //for loop
            if (studentID.toString().equals(el.getAttributeValue("sid"))) //checking condition if (studentID.toString().equals(el.getAttributeValue("sid"))) {
                recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
            }
        }
        if (recs.size() > 0) { //condition checking if ( recs.size() > 0 )
            sr.put(studentID, recs); // be careful - this could be empty
        }
        return recs; //return the value of recs
    }

    public void saveRecord(IStudentUnitRecord irec) { //save record 
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) { //for loop
            if (irec.getStudentID().toString().equals(el.getAttributeValue("sid")) && irec.getUnitCode().equals(el.getAttributeValue("uid"))) { //condition checking
                el.setAttribute("asg1", new Float(irec.getAsg1()).toString());

                el.setAttribute("asg2", new Float(irec.getAsg2()).toString());
                el.setAttribute("exam", new Float(irec.getExam()).toString());
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
                return; //return value
            }
        }

        /**
         * Exception Handling
         */
        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
    }
}
