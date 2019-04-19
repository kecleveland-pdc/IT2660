/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistapp;

/**
 *
 * @author Keigh
 */
public class Node {
    private String _name;
    private String _number;
    private String _address;
    
    public Node()
    {
        _name = "";
        _address = "";
        _number = "";
    }
    
    public Node(String name, String number, String address)
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
    
    public Node deepCopy()
    {
        Node clone = new Node(_name, _address, _number);
        return clone;
    }
       
    @Override
    public String toString(){
        return "Student Name: " + _name 
                + " StudentAddress: " + _address 
                + " StudentNumber: " + _number;
    }
  
}
