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
        String studentDataSet = "";
        int maxDataSet = 0;
        int endProgram = 6;
        int userInput = 0;

        try
        {
            System.out.println("Student Records App ");
            System.out.println("--------------------------------------------------");
            System.out.println("Please enter the maximum size of the data set: ");
            maxDataSet = Integer.parseInt(scanUtil.nextLine());
     
            System.out.println("Please enter initial student data set in the folllwing format:\nStudentName1,StudentAddress1,StudentNumber1;StudentName2,StudentAddress2,StudentNumber2;...");
            studentDataSet = scanUtil.nextLine();
            StudentRecords records = InitStudentRecords(maxDataSet, studentDataSet);
            System.out.println("Initial data set\n" + records.toString());
           
            ////CLEAN THIS UP IN LESSON 3 -- 3/11/2019////
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
                    System.out.println("Please enter student data to insert in the format StudentName,Address(City),StudentNumber");
                    targetKey = scanUtil.nextLine();
                    String[] studentData = targetKey.split(",");
                    records.Insert(new Node(studentData[0], studentData[1], studentData[2]));
                    //System.out.println("Inserted " + records.Fetch(studentData[0]));
                }else if(userInput == 2)
                {
                    System.out.println("Please enter a student to fetch");
                    targetKey = scanUtil.nextLine();
                   // System.out.println(records.Fetch(targetKey).toString());
                }else if(userInput == 3)
                {
                    System.out.println("Please enter a student to delete");
                    targetKey = scanUtil.nextLine();
                   // System.out.println("Deleting " + records.Fetch(targetKey).toString());
                   // records.Delete(targetKey);
                    System.out.println("Deleted " + targetKey + "\n");
                }else if(userInput == 4)
                {
                    System.out.println("Please enter a student to update, in the following format:  Student1,UpdatedStudent1Name,UpdatedStuden1tAddress,UpdatedStudent1Number");
                    targetKey = scanUtil.nextLine();
                    String[] studentData = targetKey.split(",");
                    //System.out.println(records.Update(studentData[0], new Node(studentData[1],studentData[2],studentData[3])));
                   // System.out.println("Updated " + studentData[0] + "\n" + records.Fetch(studentData[1]).toString());
                }else if(userInput == 5)
                {
                    //sort and get all records
                }
                else if((userInput !=6 && userInput < 5))
                {
                    System.out.println("Please choose an appropriate selection");
                }
            }
            System.out.println("Exiting...");
         }catch(Exception ex){
            System.out.println("Error processing: " + ex.toString());
         }
    }     
    
    public static StudentRecords InitStudentRecords(int maxDataSet, String studentDataSet)
    {
        StudentRecords studentRecords = new StudentRecords(maxDataSet);
        String[] students = GetStudentDataSet(studentDataSet);
        try
        {
          for(String student: students)
            {
                String[] studentData = student.split(",");
                String name = studentData[0];
                String address = studentData[1];
                String number = studentData[2];
            
                Node studentNode = new Node(name, address, number);
                studentRecords.Insert(studentNode);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error processing: " + ex.toString());
        }    
        return studentRecords;
    }
    
    public static String[] GetStudentDataSet(String studentDataSet)
    {
        String data;
        if(studentDataSet.endsWith(";"))
        {
            data = studentDataSet.replaceAll(";$","");
        }
        
        data = studentDataSet;
        
        return data.split(";");
    }
}
