/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javax.swing.JOptionPane;

/**
 *
 * @author Keigh
 */
public class Node {
    private int _nodeValue;
    boolean pushed; //needed to determine if pushing on stack

    
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
    
    public boolean getPushed()
    {
        return pushed;
    }
    
    public void setPushed(boolean value)
    {
        pushed = value;
    }
    
    public void visit(int vertexNumber)
    {
        System.out.println("Traveled to: Vertex[" + vertexNumber + "] with number: " + this.getNode()); //TO DO MAKE BETTER REPRESENATION
    }
    
}
