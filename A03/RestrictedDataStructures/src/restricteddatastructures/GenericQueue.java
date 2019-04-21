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
public class GenericQueue<T> {
    private T[] _data;
    private int _size;
    private int _numOfNodes;
    private int _front;
    private int _rear;
    
    public GenericQueue()
    {
       _size = 100;
       _numOfNodes = 0;
       _rear = 0;
       _data = (T[]) new Object[100];
    }
    
    public GenericQueue(int size)
    {
        _size = size;
        _numOfNodes = 0;
        _front = 0;
        _rear = 0;
        _data = (T[]) new Object[size];
    }
    
    public boolean enque(T newNode)
    {
        GenericNode node = (GenericNode) newNode;
        if(_numOfNodes == _size)
        {
            //new array
            _size = _size + 1;
            _numOfNodes = 0;
            _front = 0;
            _rear = 0;
            
            T[] larger = (T[]) new Object[_size];  
            T temp[] = _data;
            
            _data = larger;
            
            for(int i = 0; i <= temp.length-1; i++)
            {
                _numOfNodes = _numOfNodes + 1;
                _data[i] = temp[i];
                _rear = (_rear + 1) % _size;
                
            }
            
            temp = null;
            larger = null; 
        }
 
        _numOfNodes = _numOfNodes + 1;
        _data[_rear] = (T)node.deepCopy(); //now can insert the new node at the rear
        _rear = (_rear + 1) % _size;  //rear will properly be set for next enqueue
            
        return true;
    }
    
    public T deque()
    {
        int frontLocation;
        if(_numOfNodes == 0)
        {
            return null;
        }
        else
        {
            frontLocation = _front;
            _front = (_front + 1) % _size;
            _numOfNodes = _numOfNodes - 1;
            return _data[frontLocation];
        }
       
    }
    
     public Boolean isEmpty()
    {
        if(_numOfNodes == 0)
        {
            return true;
        }
        
        return false;
    }
    
    public Boolean isFull()
    {
        if(_numOfNodes == _size)
        {
            return true;
        }
        
        return false;
    }
    
    public T peek()
    {
        int frontLocation;
        if(_numOfNodes == 0)
        {
            return null;
        }
        else
        {
            frontLocation = _front;
            return _data[frontLocation];
        }
    }
    
    public void reinitQueue()
    {
        _numOfNodes = 0;
        _front = 0;
        _rear = 0;
    }
   
    public void showAll()
    {
        int i = _front;
        for(int c = 1; c <= _numOfNodes; c++)
        {
            System.out.println(_data[i].toString());
            i = (i + 1) % _size;
        }
    }
    
    public interface GenericNode
    {
        public abstract GenericNode deepCopy();
        public abstract String toString();
    }
}
