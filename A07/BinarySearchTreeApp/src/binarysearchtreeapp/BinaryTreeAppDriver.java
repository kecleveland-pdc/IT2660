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
     
        bnTree.insert(listing1);
        System.out.println(bnTree.fetch("Keaunna"));
        System.out.println(bnTree.fetch("Miyaunna"));
    }
}
