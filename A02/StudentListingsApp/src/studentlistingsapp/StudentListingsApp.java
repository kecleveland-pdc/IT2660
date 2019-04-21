/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlistingsapp;
import java.util.*;
/**
 *
 * @author Keigh
 */
public class StudentListingsApp {
    
    public static void main(String[] args) {
    
        Scanner scanUtil = new Scanner(System.in);
        String targetKey = "";
        
        int maxDataSet = 0;
        int endProgram = 6;
        int userInput = 0;

        try
        {
            System.out.println("Student Records App ");
            System.out.println("--------------------------------------------------");
            System.out.println("Please enter the maximum size of the data set: ");
            maxDataSet = Integer.parseInt(scanUtil.nextLine());
     
            System.out.println("Please follow the prompts to enter student data:");
            StudentRecords records = InitStudentRecords(maxDataSet);
            System.out.println("Initial data set"); 
            records.showAll();
            
           
            while(endProgram != userInput)
            {
                System.out.println("Please make a selection: ");
                System.out.println("--------------------------------------------------");
                System.out.println("1. Insert New Student Data\n"
                        + "2. Fetch Student Data\n"
                        + "3. Delete Student Data\n"
                        + "4. Update Student Data\n"
                        + "5. Get All Student Data\n"
                        + "6. Exit the program\n"
                );
                
                userInput = Integer.parseInt(scanUtil.nextLine());
                
                if(userInput == 1)
                {
                    Node listing = new Node();
                    listing.input();
                    records.insert(listing);
                    System.out.println("Inserted " + records.fetch(listing.getStudentName()));
                 
                }else if(userInput == 2)
                {
                    System.out.println("Please enter a student to fetch");
                    targetKey = scanUtil.nextLine();
                    System.out.println(records.fetch(targetKey).toString());
                }else if(userInput == 3)
                {
                    System.out.println("Please enter a student to delete");
                    targetKey = scanUtil.nextLine();
                    System.out.println("Deleting " + records.fetch(targetKey).toString());
                    records.delete(targetKey);
                    System.out.println("Deleted " + targetKey + "\n");
                }else if(userInput == 4)
                {
                    System.out.println("Please enter a student to update:");
                    targetKey = scanUtil.nextLine();
                    Node listing = new Node();
                    listing.input(targetKey);
                    records.insert(listing);
                }else if(userInput == 5)
                {
                    System.out.println("Here is the current list: ");
                    records.showAll();
                }
                else if(( userInput != 6 && userInput > 6 ))
                {
                    System.out.println("Please choose an appropriate selection");
                }
            }
            System.out.println("Exiting...");
         }catch(Exception ex){
            System.out.println("Error processing: " + ex.toString());
         }
    }     
    
    public static StudentRecords InitStudentRecords(int maxDataSet)
    {
        StudentRecords studentRecords = new StudentRecords(maxDataSet);  
        try
        {
             for(int i = 0; i < maxDataSet; i++)
            {
                Node listing = new Node();
                listing.input();
                studentRecords.insert(listing);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error processing: " + ex.toString());
        }    
        return studentRecords;
    }    
}
