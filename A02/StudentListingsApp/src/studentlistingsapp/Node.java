/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlistingsapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Keigh
 */
public class Node {
    private String _studentName;
    private String _studentNumber;
    private String _studentGPA;
    
    public Node()
    {
        _studentName = "";
        _studentNumber = "";
        _studentGPA = "";
    }
    
    public Node(String studentName, String studentNumber, String studentGPA)
    {
        _studentName = studentName;
        _studentNumber = studentNumber;
        _studentGPA = studentGPA;
    }
    
    public String getStudentName()
    {
        return _studentName;
    }
    
    public void setStudetName(String name)
    {
        _studentName = name;
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
    

    public int compareTo(String targetKey)
   {
        return(_studentName.compareTo(targetKey));

   }
    

    public Node deepCopy()
    {
        Node clone = new Node(_studentName, _studentNumber, _studentGPA);
        return clone;
    }
    
    public void input()
    {
        _studentName = JOptionPane.showInputDialog("Enter the student's name");
        _studentGPA = JOptionPane.showInputDialog("Enter the student's number");
        _studentNumber = JOptionPane.showInputDialog("Enter the student's GPA");     
    }
    
    public void input(String targetKey)
    {
        _studentName = JOptionPane.showInputDialog("Please update " + targetKey + "'s name");
        _studentGPA = JOptionPane.showInputDialog("Please update " + targetKey + "'s student number.");
        _studentNumber = JOptionPane.showInputDialog("Please update " + targetKey + "'s GPA");     
    }
     
       
    @Override
    public String toString(){
        return "\nStudent Name: " + _studentName 
                + "\nStudent Number: " + _studentNumber
                + "\nStudent GPA: " + _studentGPA;       
    }
  
}
