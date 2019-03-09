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
        String studentDataSet = "";
        
        try
        {
            Run(scanUtil, maxDataSet, initNumOfStudents, studentDataSet);       
            
         }catch(Exception ex){
            System.out.println("Error processing: " + ex.toString());
         }
    }     
    
    public static void Run(Scanner scanUtil, int maxDataSet, int initNumberOfStudents, String studentDataSet)
    {

        String initDataSet;
        System.out.println("Student Records App ");
        System.out.println("--------------------------------------------------");
        System.out.println("Please enter the maximum size of the data set: ");
        maxDataSet = Integer.parseInt(scanUtil.nextLine());
        
        System.out.println("Please enter initial number of students: ");
        initNumberOfStudents = Integer.parseInt(scanUtil.nextLine());   
        
        System.out.println("Please enter initial student data set in the folllwing format: ");
        System.out.println("StudentName1,StudentAddress1,StudentNumber1;StudentName2,StudentAddress2,StudentNumber2;...");
        initDataSet = scanUtil.nextLine();
        //System.out.println(initDataSet);
    
    }
    
    public static StudentRecords GetStudentRecords(StudentRecords studentRecords, String studentDataSet)
    {
        String[] students = studentDataSet.split(";");
        for(String student: students)
        {
            String[] studentData = student.split(",");
            String name = studentData[0];
            String address = studentData[1];
            String number = studentData[2];
            
            Node studentNode = new Node(name, address, number);
            studentRecords.insert(studentNode);
        }
        
        return studentRecords;
    }
}
