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
public class Stack {
    private Listing[] data;
    private int top;
    private int size;
    
    public Stack (int n)
    {
        top = -1;
        size = n;
        data = new Listing[n];
    }
    
    public boolean push(Listing newNode)
    {
        if(top == size - 1)
        {
            return false; 
        }
        else
        {
            top = top + 1;
            data[top] = newNode.deepCopy();
            return true;
        }
    }
}
