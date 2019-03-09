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
        int maxDataSet = 0;
        int initNumOfStudents = 0;
        
        System.out.print("Student Records App");
        try
        {
            RunSetUp(scanUtil);
            System.out.print("Student Records App");
            System.out.print("-------------------");
            System.out.print("Please enter the maximum size of the data set:");
            maxDataSet = Integer.parseInt(scanUtil.nextLine());
            System.out.print("Please enter initial number of students:");
            initNumOfStudents = Integer.parseInt(scanUtil.nextLine());   
            System.out.print("Please enter initial student data set in the folllwing format:\n");
            System.out.print("StudentName1,StudentAddress1,StudentNumber1;StudentName2,StudentAddress2,StudentNumber2;...");
         }catch(Exception ex){
            System.out.println("Error processing: " + ex.toString());
         }
    }     
    
    public static void RunSetUp(Scanner scanUtil)
    {
    
    }
    
    public static void CreateInitialDataSet(List<String> initDataSet)
    {
        for(String student: initDataSet)
        {
            String name = "";
            String address  = "";
            String number = "";
            
            Node studentNode = new Node(name, address, number);
        }
    }
}
