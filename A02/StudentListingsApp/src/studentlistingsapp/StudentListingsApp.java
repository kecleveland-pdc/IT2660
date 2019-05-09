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
            System.out.println(records.toString()); 
            
            while(userInput != endProgram)
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
                    records.Insert(listing);
                    System.out.println("Inserted " + records.Fetch(listing.getName()));
                 
                }else if(userInput == 2)
                {
                    System.out.println("Please enter a student to fetch");
                    targetKey = scanUtil.nextLine();
                    if(records.Fetch(targetKey) != null)
                    {
                        System.out.println(records.Fetch(targetKey).toString());
                    }
                    else
                    {
                        System.out.println(targetKey + " is not in the data set."); 
                    }           
                }else if(userInput == 3)
                {
                    System.out.println("Please enter a student to delete");
                    targetKey = scanUtil.nextLine();
                    System.out.println("Deleting " + targetKey);
                    if(records.Delete(targetKey))
                    {
                        System.out.println("Deleted " + targetKey + "\n");
                    }else
                    {
                        System.out.println(targetKey + " is not in the data set."+ "\n");
                    }     
                }else if(userInput == 4)
                {
                    System.out.println("Please enter a student to update:");
                    targetKey = scanUtil.nextLine();
                    Node listing = new Node();
                    listing.input(targetKey);
                    if(records.Update(targetKey, listing))
                    {
                        System.out.println("Updated " + targetKey + "\n");
                    }else
                    {
                        System.out.println(targetKey + " is not in the data set."+ "\n");
                    }
                }else if(userInput == 5)
                {
                    System.out.println("Here is the current list: ");
                    System.out.println(records.toString());
                }
                else if(( userInput != 6 && userInput > 6 ))
                {
                    System.out.println("Please choose an appropriate selection");
                }
            }
            System.out.println("Exiting...");
         }
        catch(Exception ex)
        {
            System.out.println("Error processing: " + ex.toString());
        }
        
    }
    
    public static StudentRecords InitStudentRecords(int maxDataSet)
    {
        StudentRecords studentRecords = new StudentRecords();
     
        try
        {
             for(int i = 0; i < maxDataSet; i++)
            {
                Node node = new Node();
                node.input();
                studentRecords.Insert(node);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error processing: " + ex.toString());
        }    
        return studentRecords;
    }

  }
