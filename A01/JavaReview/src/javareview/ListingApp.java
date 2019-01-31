/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;
import java.util.Scanner;

/**
 *
 * @author Keigh
 */
public class ListingApp {
    
    public static void main(String[] args) {
        
        Listing listingsArray[]; 
        Listing reversedArray[];
        listingsArray = new Listing[3];
        Scanner scanUtil = new Scanner(System.in);
        
        String userName;
        int userAge;
        int count = 0;
        
        while(count <= 2){
            try{
                Listing listing = new Listing();
                System.out.print("Please enter the name: ");
                userName = scanUtil.nextLine();
                System.out.print("Please enter the age: ");
                userAge = Integer.parseInt(scanUtil.nextLine());          
                listing.input(userName, userAge);
                listingsArray[count] = listing;
                System.out.println(listingsArray[count].toString());         
            }catch(Exception ex){
                System.out.println("Error processing: " + ex.toString());
            }
            
            count ++;
        }
        
        reversedArray = getReverseListingArray(listingsArray);
        System.out.println("Reversed....");     
        for(Listing arrayItem : reversedArray ){
           System.out.println(arrayItem.toString());
        }
    }
    
    public static Listing[] getReverseListingArray(Listing listingsArray[]){    
        Listing reverseArray[];
        reverseArray = new Listing[3];
        
        try{ 
            for(int i = 0; i <= listingsArray.length-1; i++){
            reverseArray[i] = (listingsArray[(listingsArray.length-1)-i]);
            }
        }
        catch(Exception ex){
            System.out.println("Error processing: " + ex.toString());
        }
        
        return reverseArray;
    }
}
