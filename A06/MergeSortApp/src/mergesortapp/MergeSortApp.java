/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortapp;
import java.util.*;

/**
 *
 * @author Keigh
 */
public class MergeSortApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        ArrayList<Integer> mergeSortedArrList = new ArrayList<Integer>();
        int MIN = 0;
        int MAX = 1000;
        int ARRAY_LIST_SIZE = 100;
        
        while(arrList.size() <= ARRAY_LIST_SIZE - 1)
        {
            int newRandom = GenerateRandomNumber(MIN, MAX);
            
            if(!arrList.contains(newRandom))
            {
                arrList.add(newRandom);
            }
        }
        
        System.out.println("Unsored arrayList... ");
        ShowAll(arrList);
        
        System.out.println("Sorting arrayList...");
        mergeSortedArrList = MergeSort(arrList);
        
        //show all sorted
        System.out.println("Showing sorted arrayList...");
        ShowAll(mergeSortedArrList);
    }
    
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arrList)
    {
        ArrayList<Integer> arrListLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrListRight = new ArrayList<Integer>();
     
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
    
    public static int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
	Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        return newRandom;

    }
    
    public static ArrayList<Integer> Merge(ArrayList<Integer> arrListLeft, ArrayList<Integer> arrListRight)
    {
        //while arrListLeft and arrListRight are both not empty
            //add first item to sortedArrList via comparison
            //set left/right arrList to new arrList by removing arrList[0]
            //add non-empty arrList item back to sortedArrList 
       //return sortedArray
        
        ArrayList sortedArrList = new ArrayList<Integer>(); //sortedArray 
        
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
        for (Integer item : arrList)
        {
            System.out.println(item);
        }
    }
}
