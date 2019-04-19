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
        Queue queue = new Queue(3); 
        
        Listing li = new Listing("Keaunna", "123 Street", "123 1111");
        Listing li2 = new Listing("Miya", "111 Street", "123 0000");
        Listing li3 = new Listing("Sharlene", "456 Street", "123 4444");
        Listing li4 = new Listing("Expander", "000 Street", "000 0000");
        Listing popped;
        Listing dequed;
        
        System.out.println("Now working with the STACK:");
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
         
        //pushing on stack
        System.out.println("Pushing onto the stack...");
        stack.push(li);
        stack.push(li2);
        stack.push(li3);
        
        //expanding full stack
        System.out.println("This is the current stack...");
        System.out.println("-----------------------------------");
        stack.showAll();
        
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
        System.out.println("-----------------------------------");
        System.out.println("This will be pushed onto the stack:\n" + li4.toString()); //should be "Expander"    
        
        //should expand stack
        stack.push(li4);  
        
        System.out.println("This is the expanded stack:"); 
        System.out.println("-----------------------------------");
        
        stack.showAll();
        
        System.out.println("-----------------------------------");
        System.out.println("Popping off the stack...");
        
        popped = stack.pop();
        
        System.out.println("This was popped:\n" + popped); //should be "Expander"
        System.out.println("This is the current stack:"); //should be "Expander"
        System.out.println("-----------------------------------");
        
        stack.showAll();
        
        System.out.println("-----------------------------------");
        
        //peeking
        System.out.println("Peeking...\n" + stack.peek());
        System.out.println("-----------------------------------");
        
        System.out.println("Now working with the QUEUE:");
        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Is the queue full? " + queue.isFull());
        System.out.println("Inserting to front of queue...");
        
        queue.enque(new Listing("QKeaunna", "111 1111", "1234 Sesame Street"));
        queue.enque(new Listing("QMiyaunna", "333 1111", "333 Sesame Street"));
        queue.enque(new Listing("QSharlene", "222 1111", "444 Sesame Street"));
        
        System.out.println("This is the current queue:");
        System.out.println("-----------------------------------");
        
        
        queue.showAll();
        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Is the queue full? " + queue.isFull());
        System.out.println("-----------------------------------");
        
        dequed = queue.deque();
        System.out.println("This was dequed:\n " + dequed.toString());
        System.out.println("This is the current queue:");
        System.out.println("-----------------------------------");
        
        queue.showAll();
        
        System.out.println("-----------------------------------");
        
        //peeking
        System.out.println("Peeking...\n" + queue.peek());  
        System.out.println("-----------------------------------");
        
    }
    
}
