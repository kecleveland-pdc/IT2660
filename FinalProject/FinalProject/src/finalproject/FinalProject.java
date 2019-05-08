/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.*;

/**
 *
 * @author Keigh
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int MIN = 1;
        int MAX = 5;
        int startingVortex = MAX-1;
        int chosenNumber;
        int chosenVortex;
        
        Scanner scanUtil = new Scanner(System.in);
        Graph graph1 = new Graph(MAX);
        System.out.println("Search App");
        System.out.println("--------------------------------------------------");
        System.out.println("Please a number to search for:");
            
        chosenNumber = Integer.parseInt(scanUtil.nextLine());

        try
        {
            for(int i = 0; i < MAX; i++)
            {
                Node newNode = new Node(GenerateRandomNumber(MIN,MAX));
                //build up graph ()
                if(!graph1.insertVertex(i, newNode))
                {
                    System.out.println("Failed to insert " + newNode.getNode());
                }
                else
                {
                    System.out.println("Inserted Vertex[" + i + "] with number: " + newNode.getNode());
                }      
            }
            
            //insert non-random adjacent edges
            graph1.insertEdge(0,1);
            graph1.insertEdge(0,3);
            graph1.insertEdge(0,4);
            graph1.insertEdge(1,0);
            graph1.insertEdge(1,2);
            graph1.insertEdge(1,3);
            graph1.insertEdge(3,0);
            graph1.insertEdge(3,4);
            graph1.insertEdge(4,0);
            graph1.insertEdge(4,3);
            
            System.out.println();
            System.out.println("Starting vortex " + (startingVortex));
            System.out.println("Starting DFT for number:  " + startingVortex + "\n");
            graph1.startDFT(startingVortex, chosenNumber);
            
            System.out.println();
            System.out.println("Starting BFT for number: " +  startingVortex+ "\n");
            graph1.startBFT(startingVortex, chosenNumber);
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