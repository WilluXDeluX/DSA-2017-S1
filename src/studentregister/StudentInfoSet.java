/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregister;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author ndm3324
 */
public class StudentInfoSet {
    private Map<String, StudentInfo>studentMap;
    private String description;
    
    public StudentInfoSet()
    {
        studentMap = new HashMap<>();
        description = null;
    }
    
    public void loadStudentsFromXML(Document doc)
    {
        studentMap.clear();
        Node rootXMLNode = doc.getDocumentElement();
        NodeList description = doc.getElementsByTagName("description");
        NodeList nodeList = doc.getElementsByTagName("student");
        this.description = description.item(0).getTextContent();
        for(int i = 0; i < nodeList.getLength(); i ++)
        {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String studentID = element.getAttribute("studentID");
            char gender = element.getAttribute("gender").charAt(0);
            String firstName = element.getElementsByTagName("firstname").item(0).getTextContent();
            String lastName = element.getElementsByTagName("lastname").item(0).getTextContent();
            String pictureURL = element.getElementsByTagName("pictureURL").item(0).getTextContent();
            NodeList birthDate = element.getElementsByTagName("birthday");
            Element tempBDay = (Element)birthDate.item(0);
            int day = Integer.parseInt(tempBDay.getAttribute("day"));
            int month = Integer.parseInt(tempBDay.getAttribute("month"));
            int year = Integer.parseInt(tempBDay.getAttribute("year"));
            LocalDate birthDay = LocalDate.of(year, month, day);
            StudentInfo student = new StudentInfo(studentID,firstName,lastName,birthDay,gender);
            List<String> papers = new ArrayList<>();
            NodeList nListPapers = element.getElementsByTagName("paper");
            for(int j = 0; j < nListPapers.getLength();j++)
            {
                papers.add(nListPapers.item(j).getTextContent());
                student.addPaper(nListPapers.item(j).getTextContent());
            }
            student.setPictureFromFileName(pictureURL);
//            student.setEnrolledPapers(papers);
            studentMap.put(studentID, student);
            
        }
    }
    
    public void addStudent(StudentInfo student)
    {
        studentMap.put(student.getStudentID(), student);
      
    }
    
    public void removeStudent(String studentID)
    {
        studentMap.remove(studentID);
    }
    
    public StudentInfo getStudent(String studentID)
    {
        return studentMap.get(studentID);
    }
    
    public void clear()
    {
        studentMap.clear();
    }
    
    public Iterator<StudentInfo> iterator()
    {
        Set<Entry<String, StudentInfo>> entrySet = studentMap.entrySet();
        Iterator<Entry<String, StudentInfo>> i = entrySet.iterator();
        
        
        Iterator<StudentInfo> it = new Iterator<StudentInfo>() {
            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public StudentInfo next() {
                if(!hasNext())
                {
                    throw new NoSuchElementException();
                }
                return i.next().getValue();
            }
        };
        return it;
    }
    
    public int size()
    {
        return studentMap.size();
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public boolean containsKey(String key)
    {
        if(studentMap.get(key)!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public Set<String> getStudentKeys()
    {
        return studentMap.keySet();
    }
    
}
