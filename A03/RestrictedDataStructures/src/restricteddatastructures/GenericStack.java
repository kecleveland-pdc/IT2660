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
public class GenericStack<T> {
    private T[] _data;
    private int _top;
    private int _size;
    
     public GenericStack ()
    {
        _top = -1;
        _size = 100;
        _data = (T[]) new Object[100];
    }
     
    public GenericStack (int n)
    {
        _top = -1;
        _size = n;
        _data = (T[]) new Object[n];
    }
   
    public boolean push(T newNode)
    {
        GenericNode node = (GenericNode) newNode;
        if(_top == _size - 1)
        {
            _size = _size+1;
            T[] larger = (T[]) new Object[_size];
            
            ///expand stack
            T temp[] = _data;
            _data = larger;
            for(int i = 0; i <= temp.length-1; i++)
            {
                _data[i] = temp[i];
            }
            
            temp = null;
            larger = null;  
        }
       
        _data[_top + 1] = (T)node.deepCopy();
        _top = _top + 1;
        
        return true;
    }
    
    public T pop()
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
    
    public T peek()
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
    
    public interface GenericNode
    {
        public abstract GenericNode deepCopy();
        public abstract String toString();
    }
}
