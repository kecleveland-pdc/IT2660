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
public class Stack {
    private Listing[] _data;
    private int _top;
    private int _size;
    
    public Stack (int n)
    {
        _top = -1;
        _size = n;
        _data = new Listing[n];
    }
    
    public boolean push(Listing newNode)
    {
        if(_top == _size - 1)
        {
            Listing[] larger = new Listing[_size+1];
            
            ///expand stack
            Listing temp[] = _data;
            _data = larger;
            for(int i = 0; i <= temp.length-1; i++)
            {
                _data[i] = temp[i];
            }
            
            temp = null;
            larger = null;  
        }

        _top = _top + 1;
        _data[_top] = newNode.deepCopy();
        return true;
    }
    
    public Listing pop()
    {
        int topLocation;
        if(_top == -1)
        {
            return null;
        }
        else
        {
            topLocation = _top;
            _top = _top - 1;
            return _data[topLocation];
        }
    }
    
    public void reInitToEmpty()
    {
        _top = -1;
    }
    
    public Boolean isEmpty()
    {
        if(_top == -1)
        {
            return true;
        }
        
        return false;
    }
    
    public Boolean isFull()
    {
        if(_top == _size-1)
        {
            return true;
        }
        
        return false;
    }
    
    public Listing peek()
    {
        int topLocation;
        if(_top == -1)
        {
            return null;
        }
        else
        {
            topLocation = _top;
            return _data[topLocation];
        }
    }
    
    public void showAll()
    {
        for(int i = _top; i >= 0; i--)
        {
            System.out.println(_data[i].toString());
        }
    }
}
