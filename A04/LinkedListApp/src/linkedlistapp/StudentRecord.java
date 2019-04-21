/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Keigh
 */
public class StudentRecord implements GenericSLL.GenericNode {
    private String _name;
    private String _studentNumber;
    private String _studentGPA;
    private String _studentCampus;
    private String _studentEnrollmentYear;
    
    public StudentRecord()
    {
        _name = "";
        _studentNumber = "";
        _studentCampus = "";
        _studentGPA = "";
        _studentEnrollmentYear = "";
    }
    
    public StudentRecord(String name, String studentNumber, String studentGPA, String studentCampus, String studentEnrollmentYear)
    {
        _name = name;
        _studentNumber = studentNumber;
        _studentGPA = studentGPA;
        _studentCampus = studentCampus;
        _studentEnrollmentYear = studentEnrollmentYear;
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
    
    public void setStudentEnrollmentYear(String studentEnrollmentYear)
    {
        _studentCampus = studentEnrollmentYear;
    }
    
    public String getStudentEnrollmentYear()
    {
        return _studentEnrollmentYear;
    }
    
   @Override
   public int compareTo(String targetKey)
   {
        return(_name.compareTo(targetKey));

   }
    
    @Override
    public StudentRecord deepCopy()
    {
        StudentRecord clone = new StudentRecord(_name, _studentNumber, _studentGPA, _studentCampus, _studentEnrollmentYear);
        return clone;
    }
    
    public void input()
    {
        _name = JOptionPane.showInputDialog("Enter student's name: ");
        _studentNumber = JOptionPane.showInputDialog("Enter student's number:");
        _studentGPA = JOptionPane.showInputDialog("Enter student's GPA:"); 
        _studentCampus = JOptionPane.showInputDialog("Enter student's campus: ");
        _studentEnrollmentYear = JOptionPane.showInputDialog("Enter student's enrollment  year:");  
    }
    
    @Override
    public String toString()
    {
        if (_name.equals(" ")) {
            _name = "N/A";
        }
        
        return "\nStudent Name: " + _name
                + "\nStudent Number: " + _studentNumber
                + "\nStudent GPA: " + _studentGPA
                + "\nStudent Campus: " + _studentCampus 
                + "\nStudent Enrollment Year: " + _studentEnrollmentYear + "\n";
    }
}
