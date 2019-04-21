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
        GenericStack<Listing> sListing = new GenericStack<Listing>(2);
        GenericQueue<Listing> qListing = new GenericQueue<Listing>(2); 
        GenericStack<StudentRecord> sRecord = new GenericStack<StudentRecord>(2);
        GenericQueue<StudentRecord> qRecord = new GenericQueue<StudentRecord>(2); 
        
        Listing li = new Listing("Keaunna", "123 Street", "123 1111");
        Listing li2 = new Listing("Miya", "111 Street", "123 0000");
        Listing li3 = new Listing("Sharlene", "456 Street", "123 4444");
        Listing li4 = new Listing("Expander", "000 Street", "000 0000");
        
        StudentRecord r1 = new StudentRecord("Keaunna", "1", "3.5", "Metro");
        StudentRecord r2 = new StudentRecord("Miyaunna", "2", "3.9", "West");
        StudentRecord r3 = new StudentRecord("QKeaunna", "1", "3.5", "Metro");
        StudentRecord r4 = new StudentRecord("QMiyaunna", "2", "3.9", "West");
        
        Object popped;
        Object dequed;
        
        System.out.println("Now working with the STACK:");
        System.out.println("Is the stack empty? " + sListing.isEmpty());
        System.out.println("Is the stack full? " + sListing.isFull());
         
        //pushing on stack
        System.out.println("Pushing onto sListing...");
        sListing.push(li);
        sListing.push(li2);
        sListing.push(li3);
        
        //expanding full stack
        System.out.println("This is the current sListing...");
        System.out.println("-----------------------------------");
        sListing.showAll();
        
        System.out.println("Pushing onto sRecord...");
        sRecord.push(r1);
        sRecord.push(r2);
        
        System.out.println("This is the current sRecord...");
        System.out.println("-----------------------------------");
        sRecord.showAll();
    
        
        System.out.println("Is sListing empty? " + sListing.isEmpty());
        System.out.println("Is sListing full? " + sListing.isFull());
        System.out.println("Is sRecord empty? " + sRecord.isEmpty());  
        System.out.println("Is sRecord full? " + sRecord.isFull());
        System.out.println("-----------------------------------");
        System.out.println("This will be pushed onto the stack:\n" + li4.toString()); //should be "Expander"    
        
        //should expand stack
        sListing.push(li4);  
        
        System.out.println("This is the expanded stack:"); 
        System.out.println("-----------------------------------");
        
        sListing.showAll();
        
        System.out.println("-----------------------------------");
        System.out.println("Popping off the stack...");
        
        popped = sListing.pop();
        
        System.out.println("This was popped:\n" + popped); //should be "Expander"
        System.out.println("This is the current stack:"); //should be "Expander"
        System.out.println("-----------------------------------");
        
        sListing.showAll();
        
        System.out.println("-----------------------------------");
        
        //peeking
        System.out.println("Peeking sListing...\n" + sListing.peek());
        System.out.println("-----------------------------------");
        System.out.println("Peeking sRecord...\n" + sRecord.peek());
        System.out.println("-----------------------------------");
        
        System.out.println("Now working with the QUEUE:");
        System.out.println("Is qListing empty? " + qListing.isEmpty());
        System.out.println("Is qListing full? " + qListing.isFull());
        System.out.println("Is qRecord empty? " + qRecord.isEmpty());
        System.out.println("Is qRecord full? " + qRecord.isFull());
        System.out.println("Inserting to back of qListing...");
        
        qListing.enque(new Listing("QKeaunna", "111 1111", "1234 Sesame Street"));
        qListing.enque(new Listing("QMiyaunna", "333 1111", "333 Sesame Street"));
       
        System.out.println("This is the current qListing queue:");
        System.out.println("-----------------------------------");
        qListing.showAll();
        
        System.out.println("Inserting qRecord to back of queue...");
        qRecord.enque(r3);
        qRecord.enque(r4);
        
        System.out.println("This is qRecord queue...");
        System.out.println("-----------------------------------");
        qRecord.showAll();
              
        System.out.println("Is qListing empty? " + qListing.isEmpty());
        System.out.println("Is qListing full? " + qListing.isFull());
        System.out.println("Is qRecord empty? " + qRecord.isEmpty());
        System.out.println("Is qRecord full? " + qRecord.isFull());
        System.out.println("-----------------------------------");
        
        qListing.enque(new Listing("QSharlene", "222 1111", "444 Sesame Street"));
        
        System.out.println("Inserting to back of the Listing queue...");
        qListing.showAll();
   
        dequed = qListing.deque();
        System.out.println("This was dequed:\n " + dequed.toString());
        System.out.println("This is the current qListing queue:");
        System.out.println("-----------------------------------");
        
        qListing.showAll();
        
        System.out.println("-----------------------------------");
        
        //peeking
        System.out.println("Peeking qListing queue...\n" + qListing.peek());  
        System.out.println("-----------------------------------");
        System.out.println("Peeking qRecord queue..\n" + qRecord.peek());  
        System.out.println("-----------------------------------");
        
    }
    
}
