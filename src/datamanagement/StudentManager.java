/** 
* @author Ramanpreet Kaur
* @course Master of Information Technology
* @subject Professional Programming Practice
* @instructor Dr Recep Ulusoy
* @date 20.08.2016
*/

package datamanagement;

/** Importing classes for the code */
import org.jdom.*;
import java.util.List;

/** Start of the class*/
public class StudentManager{
    private static StudentManager self = null;
	private StudentMap sm;
	private java.util.HashMap<String, StudentMap> um;
	
	public static StudentManager get(){
        if (self == null)
        self = new StudentManager(); 
			return self; 
	}
	private StudentManager(){
		sm = new StudentMap();
        um = new java.util.HashMap<>();
	}
    public IStudent getStudent(Integer id){
		IStudent is = sm.get(id);
			return is != null ? is : createStudent(id);
    }

	private Element getStudentElement(Integer id){
		/** change XMLManager to XmlManager as abbreviations and acronyms should not be uppercase*/
        for (Element el : (List<Element>) XmlManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
            if (id.toString().equals(el.getAttributeValue("sid"))) 
				return el;
			return null;
    }
    private IStudent createStudent(Integer id){
        IStudent is;
        Element el = getStudentElement(id);
        if (el != null){
            StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
			is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);
			sm.put(is.getID(), is);
			return is; }
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}
    private IStudent createStudentProxy(Integer id){
		Element el = getStudentElement(id);
        if (el != null) return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
	}

    public StudentMap getStudentsByUnit(String uc){
        StudentMap s = um.get(uc);
        if (s != null) 
			{
				return s;
            }
		s = new StudentMap();
		IStudent is;
		StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord S : ur){
            is = createStudentProxy(new Integer(S.getStudentID()));
			s.put(is.getID(), is);
		}
		um.put( uc, s);
			return s;
	}
}//End of the class
