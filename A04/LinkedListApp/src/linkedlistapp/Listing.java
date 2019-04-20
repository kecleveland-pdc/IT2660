/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistapp;
import javax.swing.*;  
/**
 *
 * @author Keigh
 */
public class Listing {
    private String _name;
    private String _number;
    private String _address;
    
    public Listing()
    {
        _name = "";
        _number = "";
        _address = "";
    }
    
    public Listing(String name, String number, String address)
    {
        _name = name;
        _number = number;
        _address = address;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }
    
    public String getNumber()
    {
        return _number;
    }
    
    public void setNumber(String number)
    {
        _number = number;
    }
    
    public int compareTo(String targetKey)
   {
        return(_name.compareTo(targetKey));

   }
    
    public Listing deepCopy()
    {
        Listing clone = new Listing(_name, _number, _address);
        return clone;
    }
    
    public void input()
    {
        _name = JOptionPane.showInputDialog("Enter a name: ");
        _address = JOptionPane.showInputDialog("Enter an number");
        _number = JOptionPane.showInputDialog("Enter an address");     
    }
       
    @Override
    public String toString(){
        return "\nStudent Name: " + _name 
                + "\nStudentNumber: " + _number
                + "\nStudentAddress: " + _address;       
    }
  
}
