/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeapp;

/**
 *
 * @author Keigh
 */
public class BinaryTreeAppDriver {
     public static void main(String[] args) {
        BinaryTree bnTree = new BinaryTree();
        Listing listing1 = new Listing("Keaunna", "1", "3.5");
        Listing listing2 = new Listing("Miyaunna", "2", "4.0");
        Listing listing3 = new Listing("Sharlene", "3", "3.9");
     
        bnTree.insert(listing1);
        bnTree.insert(listing2);
        bnTree.insert(listing3);
        
        System.out.println(bnTree.fetch("Keaunna"));
        System.out.println(bnTree.fetch("Miyaunna"));
        System.out.println(bnTree.fetch("Sharlene"));
        
        bnTree.update("Keaunna", new Listing("Keigh", "1", "3.5"));
        bnTree.update("Miyaunna", new Listing("Miya", "1", "4.0"));
        bnTree.update("Sharlene", new Listing("Shar", "1", "3.9"));
        
        System.out.println(bnTree.fetch("Keaunna"));
        System.out.println(bnTree.fetch("Miyaunna"));
        System.out.println(bnTree.fetch("Sharlene"));
        
        System.out.println(bnTree.fetch("Keigh"));
        System.out.println(bnTree.fetch("Miya"));
        System.out.println(bnTree.fetch("Shar"));
        
        System.out.println("Deleted? " + bnTree.delete("Keigh"));
        System.out.println(bnTree.fetch("Keigh"));
        
    }
}
