/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Random;

/**
 *
 * @author Keigh
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int MIN = 0;
        int MAX = 10;
        Graph graph1 = new Graph(MAX);
        
        try
        {
            for(int i = MIN; i < MAX; i++)
            {
                Node newNode = new Node(GenerateRandomNumber(MIN,MAX));
                //build up graph ()
                if(!graph1.insertVertex(i, newNode))
                {
                    System.out.println("Failed to insert " + newNode.getNode());
                }
                else
                {
                    System.out.println("Inserted " + newNode.getNode());
                }      
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }       
    }
    
    public static int GenerateRandomNumber(int min, int max)
    {
        int newRandom;
	Random r = new Random();
	
        newRandom = r.nextInt((max - min) + 1) + min;
        return newRandom;

    }
    
}
