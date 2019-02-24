/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;

/**
 *
 * @author Keigh
 */
public class BookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println();
        System.out.println("In Order:");
        Bookshelf shelf1 = new Bookshelf(new Book("Book One"));
        shelf1.insert(new Book("Book Two"), 1);
        shelf1.insert(new Book("Book Three"), 2);
        shelf1.insert(new Book("Book Four"), 3);
        shelf1.insert(new Book("Book Five"), 4);
        shelf1.print();

        System.out.println();
        System.out.println("Reverse Order:");
        Bookshelf shelf2 = new Bookshelf(new Book("Book One"));
        shelf2.insert(new Book("Book Two"), 0);
        shelf2.insert(new Book("Book Three"), 0);
        shelf2.insert(new Book("Book Four"), 0);
        shelf2.insert(new Book("Book Five"), 0);
        shelf2.print();

        System.out.println();
        System.out.println("Mixed Order:");
        Bookshelf shelf3 = new Bookshelf(new Book("Book One"));
        shelf3.insert(new Book("Book Two"), 1);
        shelf3.insert(new Book("Book Three"), 2);
        shelf3.insert(new Book("Book Four"), 1);
        shelf3.insert(new Book("Book Five"), 2);
        shelf3.print();
    }
    
}
