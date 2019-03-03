/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlistingsapp;
/**
 *
 * @author Keigh
 */
public class StudentListingsDriver {
     public static void main(String[] args) {
         
         Node student = new Node("Keaunna", "Cleveland", "1");
         Node studentDeepCopy = student.deepCopy();
         Node studentShallowCopy = student; //is this a real shallow copy?
         //check values
         System.out.println("Original object: " + student.toString());
         System.out.println("Shallow copied object: " + studentShallowCopy.toString());
         System.out.println("Deep copied object: " + studentDeepCopy.toString());
         
         student.setName("Keigh");
         
         //shallow copied object values change as well 
         System.out.println("Original object: " + student.toString());
         System.out.println("Shallow copied object: " + studentShallowCopy.toString());
         System.out.println("Deep copied object: " + studentDeepCopy.toString());
         
         
         //testing the INSERT AND FETCH methods
         StudentRecords insertRecord = new StudentRecords();
         insertRecord.insert(studentDeepCopy);
         
         System.out.println("Testing fetch");
         System.out.println(insertRecord.fetch("Keaunna"));
         
    }
}

