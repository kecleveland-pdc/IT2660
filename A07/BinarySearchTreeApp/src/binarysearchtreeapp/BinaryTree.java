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
public class BinaryTree {
    Node root;
    
    public BinaryTree()
    {
        root = null; 
    }
    
    public boolean insert(Listing newListing)
    {
        //create parent/child node wrappers
        NodeWrapper nodeWrapperParent = new NodeWrapper();
        NodeWrapper nodeWrapperChild = new NodeWrapper();
        Node curNode = new Node();
        
        if(curNode == null)
        {
            return false; // no memory
        }
        else
        {
            curNode.listingNode = newListing.deepCopy();
            curNode.leftChild = null;
            curNode.rightChild  = null;
        }
        
        return true;
    }
    
    //needs to be part of BinaryTree
    public class Node 
    {

        private Listing listingNode;
        private Node leftChild;
        private Node rightChild;

        public Node() 
        {
        }
    }
    
    //needs to be part of BinaryTree
    public class NodeWrapper 
    {
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
}


