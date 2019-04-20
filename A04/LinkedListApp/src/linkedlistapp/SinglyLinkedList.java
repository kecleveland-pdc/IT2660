/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistapp;

/**
 *
 * @author Keigh
 */
public class SinglyLinkedList {
    private Node _h;
    
    public SinglyLinkedList()
    {
        _h = new Node();
        _h.l = null;
        _h.next = null;
    }
    
    public boolean insert(Listing newListing)
    {
        Node n = new Node();
        if(n == null)
        {
            return false;
        }
        else
        {
            n.next = _h.next;
            _h.next = n;
            n.l = newListing.deepCopy();
            return true; 
        }
    }
    
    public Listing fetch(String targetKey)
    {
        Node p = _h.next;
        while(p!= null && !(p.l.compareTo(targetKey) == 0))
        {
            p = p.next;
            
        }
        
        if(p != null)
        {
            return p.l.deepCopy();
        }
        else
        {
            return null;
        }
    }
    
    public boolean delete(String targetKey)
    {
        Node q = _h;
        Node p = _h.next;
        while (p != null && p.l.compareTo(targetKey) == 0)
        {
            q = p;
            p = p.next;
        }
        if(p != null)
        {
            q.next = p.next;
            return true;
        }
        else
        {
            return false;
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
    
    
    public void showAll()
    {
        Node p = _h.next;
        while(p != null)
        {
            System.out.println(p.l.toString());
            p = p.next;
        }
    }
    
    public class Node
    {
        private Listing l;
        private Node next;
        
        public Node()
        {
        }
    }
}
