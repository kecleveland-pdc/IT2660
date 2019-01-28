/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Keigh
 */
public class ListingDriver {
     public static void main(String[] args) {
         
        //test constructor with no parameters
        Listing noParamsListing = new Listing();
        String inputName;
        int inputAge;
        
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
        Scanner scanUtil = new Scanner(System.in);
        Listing inputListingTest = new Listing();
        
        try{
            //get user input
            System.out.print("Please enter the name: ");
            inputName = scanUtil.nextLine();
            System.out.print("Please enter the age: ");
            inputAge = scanUtil.nextInt();
            
            //pass parameters 
            inputListingTest.input(inputName, inputAge);
            System.out.println(inputListingTest.toString());
            
        }
        catch(InputMismatchException ex){
            System.out.println("Enter a whole number for age: (eg. 24, 3, 1999).");
        }
    }
}
