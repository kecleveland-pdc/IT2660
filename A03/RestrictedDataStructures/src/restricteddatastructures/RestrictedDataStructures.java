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
public class RestrictedDataStructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        Listing li = new Listing("Keaunna", "123 Street", "123 1111");
        Listing li2 = new Listing("Miya", "111 Street", "123 0000");
        Listing li3 = new Listing("Sharlene", "456 Street", "123 4444");
        Listing li4 = new Listing("Expander", "000 Street", "000 0000");
        Listing popped;
        
        //checking underflow & overflow
        System.out.println(stack.checkUnderflow());
        System.out.println(stack.checkOverflow());
        
        //pushing on stack
        stack.push(li);
        stack.push(li2);
        stack.push(li3);
        
        //expanding full stack
        stack.showAll();
        stack.push(li4);  //should expand stack
        stack.showAll();
        
        //popping off stack
        popped = stack.pop();
        System.out.println("This was popped:" + popped); //should be "Expander"
        stack.showAll();
        
        //peeking
        System.out.println("Peeking..." + stack.peek());
        
    }
    
}
