/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlistingsapp;

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
    
    @Override
    public String toString(){
        return "Student Name: " + _name + " StudentAddress: " + _address + " StudentNumber: " + _number;
    }
}
