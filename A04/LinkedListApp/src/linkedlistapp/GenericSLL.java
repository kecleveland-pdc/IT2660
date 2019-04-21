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
public class GenericSLL<T> {
    private Node _h;
    
    public GenericSLL()
    {
        _h = new Node();
        _h.l = null; //Listing or other type
        _h.next = null; 
    }
    
    public boolean insert(T newNode)
    {
        //TODO: Check for already inserted key
        
        GenericNode node = (GenericNode) newNode; //cast newNode to GenericNode
        Node n = new Node();
        if(n == null)
        {
            return false;
        }
        else
        {
            n.next = _h.next;
            _h.next = n;
            n.l = (T)node.deepCopy();
            return true; 
        }
    }
    
    public T fetch(String targetKey)
    {
        //cast newNode to GenericNode
        Node p = _h.next;
        GenericNode node = (GenericNode) p.l; 
        
        while(p != null && !(node.compareTo(targetKey) == 0))
        { 
            p = p.next;
            node = (GenericNode) p.l; 
            
        }
        
        if(p != null)
        {
            //return p.l.deepCopy();
            return (T)node.deepCopy();

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
        GenericNode node = (GenericNode) p.l; 
        while (p != null && !(node.compareTo(targetKey) == 0))
        {
            q = p;
            p = p.next;
            node = (GenericNode) p.l; 
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
    
    public boolean update(String targetKey, T newNode)
    {
        if(delete(targetKey) == false)
        {
            return false;
        }
        else if(insert(newNode) == false)
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
            GenericNode node = (GenericNode) p.l; 
            System.out.println(node.toString());
            p = p.next;
        }
    }
    
    public class Node
    {
        
        private T l;
        private Node next;
        
        public Node()
        {
        }
    }
    
    public interface GenericNode
    {
        public abstract GenericNode deepCopy();
        public abstract int compareTo(String targetKey);
        public abstract String toString();
    }
}
