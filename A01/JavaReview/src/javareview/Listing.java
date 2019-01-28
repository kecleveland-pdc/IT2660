/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author Keigh
 */
public class Listing {
    private String _name;
    private int _age;
    
    public Listing()
    {
        _name = " ";
        _age = 0;
    }
    
    public Listing(String name, int age)
    {
        _name = name;
        _age = age;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }
    
    public int getAge()
    {
        return _age;
    }
    
    public void setAge(int age)
    {
        _age = age;
    }
    
    public void input(String inputName, int inputAge)
    {
       _name = inputName;
       _age = inputAge; 
    }
    
    public String toString()
    {
        if (_name.equals(" ")) {
            _name = "N/A";
        }
        
        return "Name: " + _name + "\nAge: " + _age + "\n";
    }
}
