/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Keigh
 */
public class Node {
    private int _nodeValue;
    
    Node(int value)
    {
        _nodeValue = value;
    }
    
    Node()
    {
    
    }
    
    public int getNode()
    {
        return _nodeValue;
    }
    
    public int getNode(int value)
    {
        return _nodeValue = value;
    }
    
    public Node deepCopy()
    {
        Node clone = new Node(_nodeValue);
        return clone;
    }
}
