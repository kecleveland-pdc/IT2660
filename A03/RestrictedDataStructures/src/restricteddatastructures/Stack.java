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
    
    public String checkUnderflow()
    {
        if(_top == -1)
        {
            return "The stack is empty. A pop operation on this stack will result in an underflow condition.";
        }
        
        return "The stack is not empty. A pop operation on this stack will not result in an underflow condition.";
    }
    
    public String checkOverflow()
    {
        if(_top == _size-1)
        {
            return "The stack is full. A push operation on this stack will result in an overflow condition.";
        }
        
        return "The stack is not full. A push operation on this stack will not result in an overflow condition";
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
