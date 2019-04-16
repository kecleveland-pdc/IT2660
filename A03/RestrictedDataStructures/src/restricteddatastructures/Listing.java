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
public class Listing {
    private String _name;
    private String _number;
    private String _address;
    
    public Listing()
    {
        _name = "";
        _address = "";
        _number = "";
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
    
    @Override
    public String toString()
    {
        if (_name.equals(" ")) {
            _name = "N/A";
        }
        
        return "Name: " + _name +"\n";
    }
    
    public Listing deepCopy()
    {
        Listing clone = new Listing(_name, _address, _number);
        return clone;
    }
}
