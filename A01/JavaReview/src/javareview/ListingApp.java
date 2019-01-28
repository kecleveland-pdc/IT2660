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
            }catch(Exception ex){
                System.out.println("Error processing: " + ex.toString());
            }
            
            count ++;
        }
        //3. output in reverse order     
        //reversedArray = getReverseListingArray(listingsArray);
               
        //for(Listing arrayItem : reversedArray ){
           //System.out.println(arrayItem.toString());
        //}
    }
    
    public static Listing[] getReverseListingArray(Listing listingsArray[])
    {
        //reverse algorithm thoughts
        //1. array2 == size of array1
        //2. last element in array1 == array1.length -1
        //we know we want array2's first element to equal last element in array1 so...            
            //array1[array.length-1] == array2[0]
        //that means...
                //array1[array.length-2] == array2[1]  //2nd elment equal to 2nd to last element in array
                //array1[array.length-3] == array2[2]  //3rd element equal to 3rd to last element in array
        // so... if i = 0 and array[i] is the first element in the array
        //3. for(int i = 0; i>=array1.length-1; i++)
            //array2[i] == array1[array.length-1]-i  == array[0] == array1[array.length-1] - 0 == last element
        
        Listing reverseArray[];
        reverseArray = new Listing[3];
        
        try{
        
        }
        catch(Exception ex){
            
        }
    
        return reverseArray;
    }
}
