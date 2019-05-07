/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeapp;

/**
 *
 * @author Keigh
 */
public class NodeWrapper {
    Node nodeRef = null;
    
    public NodeWrapper()
    {
    }
    
    public Node get()
    {
        return nodeRef;
    }
    
    public void set(Node n)
    {
        nodeRef = n;
    }
}
