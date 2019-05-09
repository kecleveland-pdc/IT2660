/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Keigh
 */
public class Utility {
 
    public Utility()
    {
    
    }
    
    public int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
        Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        return newRandom;

    } 
}
