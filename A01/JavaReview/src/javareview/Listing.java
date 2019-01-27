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
    
    public void input(String name, int age)
    {
       this._name = name;
       this._age = age;
    }
    
    public String toString()
    {
        if (this._name.equals(" ")) {
            this._name = "N/A";
        }
        
        return "Name: " + this._name + "\nAge: " + this._age + "\n";
    }
}
