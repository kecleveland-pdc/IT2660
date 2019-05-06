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
        int ARRLISTSIZE = 100;
        
        while(arrList.size() <= ARRLISTSIZE - 1)
        {
            int newRandom = GenerateRandomNumber(MIN, MAX);
            
            if(!arrList.contains(newRandom))
            {
                arrList.add(newRandom);
            }
        }
        
        ShowAll(arrList);
        System.out.println("arrList size " + arrList.size());
        mergeSortedArrList = MergeSort(arrList, MIN, ARRLISTSIZE);
        ShowAll(mergeSortedArrList);
    }
    
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arrList, int low, int high)
    {
        ArrayList<Integer> arrListLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrListRight = new ArrayList<Integer>();
     
        //1. Get middle
        int mid = (low + high) / 2; 
        
        //2. add to left/right arrays
        for(int i = 0; i < high; i++)
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
       //sort left and right
       arrListLeft = MergeSort(arrListLeft, low, high);
       arrListRight = MergeSort(arrListRight, low, high);
       ShowAll(arrListLeft);
       ShowAll(arrListRight);
       arrListRight = MergeSort(arrListRight, low, high);
        
        //merge leftArrayList and rightArrayList
        return Merge(arrListLeft, arrListRight);
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
        //final solution should be: //merge of leftArrayList and rightArrayList
        //get each array
        //create smaller arrlists until reaching base case (i.e. 1 item per ArrayList
        //add each item to master list via comparison
        
        ArrayList mergedArrList = new ArrayList<Integer>(100);
        
        while(!arrListLeft.isEmpty() && !arrListRight.isEmpty())
        {
            
        }
        
        
        return mergedArrList;
    }
    
    public static void ShowAll(ArrayList<Integer> arrList)
    {
        for (Integer item : arrList)
        {
            System.out.println(item);
        }
    }
}
