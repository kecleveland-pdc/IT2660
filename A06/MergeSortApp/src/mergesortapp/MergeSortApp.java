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
        // TODO code application logic here
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int MIN = 0;
        int MAX = 100;
        
        while(arr.size() <= 100)
        {
            //Min + (int)(Math.random() * ((Max - Min) + 1))
            arr.add(GenerateRandomNumber(MIN, MAX));
        }
        
        for (Integer item : arr)
        {
            System.out.println(item.toString());
        }
    }
    
    public static Arrays[] MergeSort(Arrays[] arr)
    {
        //1. split array in half (create 2 subarrays)
        //while arrays are not empty
            //if 
        return arr;
    }
    
    public static int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
	Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        return newRandom;

    }
}
