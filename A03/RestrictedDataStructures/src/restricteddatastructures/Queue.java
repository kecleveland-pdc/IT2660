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
public class Queue {
    private Listing[] _data;
    private int _size;
    private int _numOfNodes;
    private int _front;
    private int _rear;
    
    public Queue()
    {
       _size = 100;
       _numOfNodes = 0;
       _rear = 0;
       _data = new Listing[100];
    }
    
    public Queue(int size)
    {
        _size = size;
        _numOfNodes = 0;
        _front = 0;
        _rear = 0;
        _data = new Listing[size];
    }
    
    public boolean enque(Listing newNode)
    {
        
        if(_numOfNodes == _size)
        {
            return false;
        }
        else
        {
            _numOfNodes = _numOfNodes + 1;
            _data[_rear] = newNode.deepCopy();
            _rear = (_rear + 1) % _size;
             return true;
        }
    }
    
    public Listing deque()
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
    
    public Listing peek()
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
}
