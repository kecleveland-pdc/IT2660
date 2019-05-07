/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeapp;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Keigh
 */
public class Listing {
    private String _studentName;
    private String _studentNumber;
    private String _studentGPA;
    
    public Listing()
    {
        _studentName = "";
        _studentNumber = "";
        _studentGPA = "";
    }
    
    public Listing(String studetName, String studentNumber, String studentGPA)
    {
        _studentName = studetName;
        _studentNumber = studentNumber;
        _studentGPA = studentGPA;
    }
    
    public String getStudentName()
    {
        return _studentName;
    }
    
    public void setStudetName(String name)
    {
        _studentName = name;
    }
    
    public String getStudentNumber()
    {
        return _studentNumber;
    }
    
    public void setStudentNumber(String studentNumber)
    {
        _studentNumber = studentNumber;
    }
    
    public String getStudentGPA()
    {
        return _studentNumber;
    }
    
    public void setStudentGPA(String studentGPA)
    {
        _studentNumber = studentGPA;
    }
    
    
    public int compareTo(String targetKey)
   {
        return(_studentName.compareTo(targetKey));

   }
    
    public Listing deepCopy()
    {
        Listing clone = new Listing(_studentName, _studentNumber, _studentGPA);
        return clone;
    }
    
    public void input()
    {
        _studentName = JOptionPane.showInputDialog("Enter the student's name");
        _studentNumber = JOptionPane.showInputDialog("Enter the student's number");
        _studentGPA = JOptionPane.showInputDialog("Enter the student's GPA");     
    }
    
    public void input(String targetKey)
    {
        _studentName = JOptionPane.showInputDialog("Please update " + targetKey + "'s name");
        _studentNumber  = JOptionPane.showInputDialog("Please update " + targetKey + "'s student number.");
        _studentGPA = JOptionPane.showInputDialog("Please update " + targetKey + "'s GPA");     
    }
     
       
    @Override
    public String toString(){
        return "\nStudent Name: " + _studentName 
                + "\nStudent Number: " + _studentNumber
                + "\nStudent GPA: " + _studentGPA;       
    }
  
    
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arrList)
    {
        ArrayList<Integer> arrListLeft = new ArrayList<>();
        ArrayList<Integer> arrListRight = new ArrayList<>();
     
        //determine base case
        if (arrList.size() <= 1)
        {
            return arrList;
        }
                
        //get mid to be able to split arrList into two
        int mid = (arrList.size()) / 2; 
        
        try
        {
            for(int i = 0; i < arrList.size(); i++)
            {
                if(i < mid)
                {
                    arrListLeft.add(arrList.get(i));
                }
                else
                {
                    arrListRight.add(arrList.get(i));
                }
            }
        //recursively merge sort
            //create smaller sublists until reaching base case (which returns item to be compared)
         arrListLeft = MergeSort(arrListLeft);
         arrListRight = MergeSort(arrListRight);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
        return Merge(arrListLeft, arrListRight); //this will do the actual "sorting"

    }
    
    public static ArrayList<Integer> Merge(ArrayList<Integer> arrListLeft, ArrayList<Integer> arrListRight)
    {
        //while arrListLeft and arrListRight are both not empty
            //add first item to sortedArrList via comparison
            //set left/right arrList to new arrList by removing arrList[0]
            //add non-empty arrList item back to sortedArrList 
       //return sortedArray
        
        ArrayList<Integer> sortedArrList = new ArrayList<>(); //sortedArray 
        
        while(!arrListLeft.isEmpty() && !arrListRight.isEmpty())
        {
            if(arrListLeft.get(0) <= arrListRight.get(0))
            {
                sortedArrList.add(arrListLeft.get(0)); 
                arrListLeft.remove(0); //left := rest(left)
            }
            else
            {
                sortedArrList.add(arrListRight.get(0));
                arrListRight.remove(0); //right := rest(right)
            }
        }
        
        //add right to array if not empty
        while(!arrListLeft.isEmpty())
        {
            sortedArrList.add(arrListLeft.get(0));
            arrListLeft.remove(0);
        }
        
        //add right to array if not empty
        while(!arrListRight.isEmpty())
        {
            sortedArrList.add(arrListRight.get(0));
            arrListRight.remove(0);
        }
        
        return sortedArrList;
    }
    
    public static void ShowAll(ArrayList<Integer> arrList)
    {
        //functional operation
        arrList.forEach((item) -> {
            System.out.println(item);
        });
    }
    
    public static int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
	Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        
        return newRandom;
    }
    
}
