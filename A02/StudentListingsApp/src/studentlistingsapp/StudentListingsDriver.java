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
         insertRecord.insert(new Node("Keaunna2", "Cleveland", "2"));
         insertRecord.insert(student);
         insertRecord.insert(studentShallowCopy);
         
         System.out.println("Testing fetch for Keaunna");
         System.out.println(insertRecord.fetch("Keaunna"));
         System.out.println("Testing fetch for Keigh");
         System.out.println(insertRecord.fetch("Keigh"));
         System.out.println("Testing fetch for Keaunna2");
         System.out.println(insertRecord.fetch("Keaunna2"));
         System.out.println("Testing fetch for ShallowCopy");
         System.out.println(insertRecord.fetch(studentShallowCopy.getName()));
         
         //TESTING DELETE
         insertRecord.delete("Keaunna2");
         System.out.println("Deleting Keaunna2");
         System.out.println(insertRecord.fetch("Keaunna2"));
         
         //TESTING UPDATE
          System.out.println("Updating Keaunna");
         insertRecord.update("Keaunna", new Node("Keaunna3", "Cleveland", "4"));
         System.out.println(insertRecord.fetch("Keaunna3"));
    }
}

