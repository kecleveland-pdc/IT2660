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
    private String _name; //key
    private String _address;
    private String _number;
    
    public Node(){
    
    }
    
    public Node(String name, String address, String number){
        _name = name;
        _address = address;
        _number = number;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }
    
    public String getAddress()
    {
        return _address;
    }
    
    public void setAddress(String address)
    {
        _address = address;
    }
    
    public String getNumber()
    {
        return _number;
    }
    
    public void setNumber(String number)
    {
        _number = number;
    }
    
    public Node deepCopy(){
        Node clone = new Node(_name, _address, _number);
        return clone;
    }
    
   public int compareTo(String targetKey)
   {
        return(_name.compareTo(targetKey));

   }
   
   public void input()
    {
        _name = JOptionPane.showInputDialog("Enter the student's name");
        _address = JOptionPane.showInputDialog("Enter the student's address");
        _number = JOptionPane.showInputDialog("Enter the student's number");     
    }
    
    public void input(String targetKey)
    {
        _name = JOptionPane.showInputDialog("Please update " + targetKey + "'s name");
        _address  = JOptionPane.showInputDialog("Please update " + targetKey + "'s student address.");
        _number = JOptionPane.showInputDialog("Please update " + targetKey + "'s number");     
    }
     
       
    @Override
    public String toString(){
        return "\nStudent Name: " + _name 
                + "\nStudent address: " + _address
                + "\nStudent number: " + _number;       
    }
    
    public void showAll(){
        System.out.println("\nStudent Name: " + _name 
                + "\nStudent address: " + _address
                + "\nStudent number: " + _number);       
    }

}
