/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restricteddatastructures;

/**
 *
 * @author Keigh
 */
public class StudentRecord implements GenericStack.GenericNode, GenericQueue.GenericNode {
    private String _name;
    private String _studentNumber;
    private String _studentGPA;
    private String _studentCampus;
    
    public StudentRecord()
    {
        _name = "";
        _studentNumber = "";
        _studentCampus = "";
        _studentGPA = "";
    }
    
    public StudentRecord(String name, String studentNumber, String studentGPA, String studentCampus)
    {
        _name = name;
        _studentNumber = studentNumber;
        _studentGPA = studentGPA;
        _studentCampus = studentCampus;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }
    
    public String getStudentNumber()
    {
        return _studentNumber;
    }
    
    public void setStudentNumber(String studentNumber)
    {
        _studentNumber = studentNumber;
    }
    
    public String getStudentGPA()
    {
        return _studentNumber;
    }
    
    public void setStudentGPA(String studentGPA)
    {
        _studentNumber = studentGPA;
    }
    
    public String getStudentCampus()
    {
        return _studentCampus;
    }
    
    public void setStudentCampus(String studentCampus)
    {
        _studentCampus = studentCampus;
    }
    
    @Override
    public String toString()
    {
        if (_name.equals(" ")) {
            _name = "N/A";
        }
        
        return "\nName: " + _name
                + "\nStudent Number: " + _studentNumber
                + "\nStudent GPA: " + _studentGPA
                + "\nStudent Campus: " + _studentCampus + "\n";
    }
    
    @Override
    public StudentRecord deepCopy()
    {
        StudentRecord clone = new StudentRecord(_name, _studentNumber, _studentGPA, _studentCampus);
        return clone;
    }
}
