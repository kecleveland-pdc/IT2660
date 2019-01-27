/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author Keigh
 */
public class ListingDriver {
     public static void main(String[] args) {
         
        //test constructor with no parameters
        Listing noParamsListing = new Listing();
        System.out.println("noParamsListing Constructor Test");
        System.out.println("----------------------------");
        System.out.println( noParamsListing.toString());
        
        //test constructor with parameters
        Listing paramsListing = new Listing("Keaunna", 34);
        System.out.println("paramsListing Constructor Test");
        System.out.println("----------------------------");
        System.out.println(paramsListing.toString());
        
        //test getters
        System.out.println("paramsListing Getters test");
        System.out.println("----------------------------");
        System.out.println("Name: " + paramsListing.getName() +
                           "\nAge: " + String.valueOf(paramsListing.getAge()));
        //test setters
        paramsListing.setName("Keigh");
        paramsListing.setAge(35);
        System.out.println("\nparamsListing Setters test");
        System.out.println("----------------------------");
        System.out.println(paramsListing.toString());
        
        //test input
        
    }
}
