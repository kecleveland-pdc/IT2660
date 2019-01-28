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
        //1. declare arary of three Listings
        listingsArray = new Listing[3];
        Scanner scanUtil = new Scanner(System.in);
        
        String userName;
        int userAge;
        int count = 0;
        
        while(count <= 2){
            try{
                //2a. whose conents are input by the user
                Listing listing = new Listing();
                System.out.print("Please enter the name: ");
                userName = scanUtil.nextLine();
                System.out.print("Please enter the age: ");
                userAge = Integer.parseInt(scanUtil.nextLine());          
                listing.input(userName, userAge);
                
                //2b. Add to array
                listingsArray[count] = listing;
                System.out.print(listingsArray[count].toString());
                
                //3. output in reverse order     
            }catch(Exception ex){
                System.out.println("Error processing: " + ex.toString());
            }
            
            count ++;
        }
    }
    
    public void reverseListingArray(Listing listingsArray[])
    {
        //reverse algorithm      
    }
}
