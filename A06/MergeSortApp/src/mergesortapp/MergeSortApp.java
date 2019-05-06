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
        
        //ShowAll
        for (Integer item : arrList)
        {
            System.out.println(item);
        }
        
        System.out.println("arrList size " + arrList.size());
        //merge sort
        MergeSort(arrList,MIN, ARRLISTSIZE);
        //ShowAll
    }
    
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arrList, int low, int high)
    {
        ArrayList<Integer> arrListLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrListRight = new ArrayList<Integer>();
     
        int mid = (low + high) / 2; 

        //1. Get middle
        //2. add to left/right arrays
        for(int i = 0; i < mid; i++)
        {
            arrListLeft.add(arrList.get(i));
        }
        
        for(int i = mid; i < arrList.size(); i++)
        {
            arrListRight.add(arrList.get(i));
        }
        
        System.out.println("PrintingLeft..");
        
        for (Integer item : arrListLeft)
        {
            
            System.out.println(item.toString());
        }
        
        System.out.println("PrintingRight...");
        
        for (Integer item : arrListRight)
        {
            
            System.out.println(item.toString());
        }
          
        System.out.println("Count of arrListLeft " + arrListLeft.size());
        System.out.println("Count of arrListRight " + arrListRight.size());
        
        return arrList;
    }
    
    public static int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
	Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        return newRandom;

    }
}
