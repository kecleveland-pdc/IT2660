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
        
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(new Listing("Keaunna", "222 2222", "123 Sesame Street"));
        list.showAll();
    }
    
}
