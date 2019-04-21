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
public class LinkedListDriver {
    public static void main(String[] args) {
        
        GenericSinglyLinkedList<Listing> list = new GenericSinglyLinkedList<Listing>();
        list.insert(new Listing("Keaunna", "1", "3.4"));  
        System.out.println("Here is the initial list:");
        list.showAll();
        
        //inserting 
        System.out.println("------------------------------");
        System.out.println("Inserting Miyaunna's record...");
        list.insert(new Listing("Miyaunna", "2", "3.9"));
        System.out.println("Here is the new list: ");
        list.showAll();
        
        //fetch
        System.out.println("------------------------------");
        System.out.println("Fetching 'Miyaunna'...");
        System.out.println(list.fetch("Miyaunna"));
        
        System.out.println("------------------------------");
        System.out.println("Fetching 'Keaunna'...");
        System.out.println(list.fetch("Keaunna"));
        
        //update
        System.out.println("------------------------------");
        System.out.println("Updating 'Keaunna' to 'Keigh'...");
        list.update("Keaunna", new Listing("Keigh", "1", "3.7"));
        System.out.println("Here is the new list: ");
        list.showAll();
        
        //delete
        System.out.println("------------------------------");
        System.out.println("Deleting 'Miyaunna'...");
        list.delete("Miyaunna");
        System.out.println("Here is the new list: ");
        list.showAll();
    }
    
}
