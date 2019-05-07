/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeapp;

import java.util.ArrayList;
import java.util.Random;

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
                findNode(newListing.getKey(), nwParent, nwChild);
                if(newListing.getKey().compareTo(nwParent.get().listingNode.getKey()) < 0)
                {
                    //insert new node as left child
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
            //1. deleted node has no children
            if(nwChild.get().leftChild == null && nwChild.get().rightChild == null)
            {
                if(nwParent.get().leftChild == nwChild.get())  //is left child
                {
                    nwParent.get().leftChild = null; //delete
                }
                else // is right child
                {
                    nwParent.get().rightChild = null; //delete
                }
            }
            //2. deleted node has 1 child
            else if(nwChild.get().leftChild == null || nwChild.get().rightChild == null)
            {
               if(nwParent.get().leftChild == nwChild.get())
               {
                    if(nwChild.get().leftChild != null) //is leftChild
                    {
                        nwParent.get().leftChild = nwChild.get().leftChild; //has left child
                    }
                    else
                    {
                        nwParent.get().rightChild = nwChild.get().rightChild; //4. deleted node has left child
                    }
                }
               else
               {
                    if(nwChild.get().leftChild != null)
                    {
                        nwParent.get().rightChild = nwChild.get().leftChild;
                    }
                    else
                    {
                        nwParent.get().rightChild = nwChild.get().rightChild;
                    }
                }
              }
            else
            {
                nextLargest = nwChild.get().leftChild;
                largest = nextLargest.rightChild;
                if(largest !=null)
                {
                    while(largest.rightChild != null)
                    {
                        nextLargest = largest;
                        largest = largest.rightChild;
                    }
                    
                    nwChild.get().listingNode = largest.listingNode;
                    nextLargest.rightChild = largest.rightChild;
                }
                else
                {
                    nextLargest.rightChild = nwChild.get().rightChild;
                    if(nwParent.get().leftChild == nwChild.get())
                    {
                        nwParent.get().leftChild = nextLargest;
                    }
                    else
                    {
                        nwParent.get().rightChild = nextLargest;
                    }
                }
            }
                return true;
        }
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
                
                if(targetKey.compareTo(nwChild.get().listingNode.getKey()) < 0)
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
    
    public void showAll()
    {
        if(root == null)
        {
            System.out.println("The structure is empty");
        }
        else
        {
            RNLTraversal(root);
        }  
    }
    
    public void LNRTraversal(Node root) //In Order as added (in sequence)
    {
        if(root.leftChild != null)
        {
            LNRTraversal(root.leftChild);
        }

        System.out.println(root.listingNode);
        if(root.rightChild != null)
        {
           LNRTraversal(root.rightChild);
        }
    }
    
    public void RNLTraversal(Node root) //Out of order as added (in sequence) (ie descending)
    {
        if(root.rightChild != null)
        {
            LNRTraversal(root.rightChild);
        }

        System.out.println(root.listingNode);
        if(root.leftChild != null)
        {
           LNRTraversal(root.leftChild);
        }
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


