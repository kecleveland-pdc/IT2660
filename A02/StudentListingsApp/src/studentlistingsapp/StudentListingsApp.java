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
        int initNumberOfStudents = 0;
        int endProgram = 6;
        String studentDataSet = "";
        
        try
        {
            System.out.println("Student Records App ");
            System.out.println("--------------------------------------------------");
            System.out.println("Please enter the maximum size of the data set: ");
            maxDataSet = Integer.parseInt(scanUtil.nextLine());
        
            System.out.println("Please enter initial number of students: ");
            initNumberOfStudents = Integer.parseInt(scanUtil.nextLine());   //not needed?
        
            System.out.println("Please enter initial student data set in the folllwing format:\nStudentName1,StudentAddress1,StudentNumber1;StudentName2,StudentAddress2,StudentNumber2;...");
            studentDataSet = scanUtil.nextLine();
            //System.out.println(initDataSet);
            
            StudentRecords records = InitStudentRecords(maxDataSet, studentDataSet);
            int userInput = 0;
            String targetKey = "";
            
            //CLEAN THIS UP IN LESSON 3
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
                    System.out.println(records.insert(new Node(studentData[0], studentData[1], studentData[2])));
                }else if(userInput == 2)
                {
                    System.out.println("Please enter a student to fetch");
                    targetKey = scanUtil.nextLine();
                    System.out.println(records.fetch(targetKey).toString());
                }else if(userInput == 3)
                {
                    System.out.println("Please enter a student to delete");
                    targetKey = scanUtil.nextLine();
                    System.out.println(records.delete(targetKey));
                    System.out.println("Deleted " + targetKey);
                }else if(userInput == 4)
                {
                
                }else if(userInput == 5)
                {
                
                }else if((userInput !=6 && userInput < 5))
                {
                    System.out.println("Please choose an appropriate number");
                }
                //some exit strategy
            }
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
                studentRecords.insert(studentNode);
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
