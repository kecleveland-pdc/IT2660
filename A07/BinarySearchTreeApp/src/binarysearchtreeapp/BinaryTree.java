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
        NodeWrapper nwParent = new NodeWrapper();
        NodeWrapper nwChild = new NodeWrapper();
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
            if(root == null) //empty tree bc root is null 
            {
                root = curNode; //set root to curNode to start tree
            }
            else
            {
                 //find parentNode based on key, leftchild(null), rightChild(null)
                findNode(newListing.getStudentName(), nwParent, nwChild);
                if(newListing.getStudentName().compareTo(nwParent.get().listingNode.getStudentName()) < 0)
                {
                    //insert new node as left chil
                    nwParent.get().leftChild = curNode; //if nwParent.get().leftChild = curNode     
                }
                else
                {
                    //insert new node as right child
                    nwParent.get().rightChild = curNode; 
                }
            }
                    
        return true;
        }
    }
    
    public Listing fetch(String targetKey)
    {
        boolean foundNode;
        NodeWrapper nwParent = new NodeWrapper();
        NodeWrapper nwChild = new NodeWrapper();
        
        foundNode = findNode(targetKey, nwParent, nwChild);
        if(foundNode)
        {
            return nwChild.get().listingNode.deepCopy();
        }
        else
        {
            return null; //not found
        } 
    }
    
    public boolean delete(String targetKey)
    {
        boolean foundNode;
        NodeWrapper nwParent = new NodeWrapper();
        NodeWrapper nwChild = new NodeWrapper();
        Node largest;
        Node nextLargest;
        
        //find the node
        foundNode = findNode(targetKey, nwParent, nwChild);
        if(foundNode == false)
        {
            return false;
        }
        else
        {
            //figure out which case it is 
        }
        
        return true; //PLACEHOLDER
    }
    
    public boolean update(String targetKey, Listing newListing)
    {
        if(delete(targetKey) == false)
        {
            return false;
        }
        else if(insert(newListing) == false)
        {
            return false;
        }
        
        return true;
    }
    
    
    public boolean findNode(String targetKey, NodeWrapper nwParent, NodeWrapper nwChild)
    {
        nwParent.set(root);
        nwChild.set(root);
        
        if(root == null)
        {
            return true;
        }
        
        while(nwChild.get() != null)
        {
            if(nwChild.get().listingNode.compareTo(targetKey) == 0)
            {
                return true; //found the node
            }
            else
            {
                nwParent.set(nwChild.get());
                if(targetKey.compareTo(nwChild.get().listingNode.getStudentName()) < 0)
                {
                    nwChild.set(nwChild.get().leftChild);
                }
                else
                {
                    nwChild.set(nwChild.get().rightChild);
                }
            }
        }
         return false;
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


