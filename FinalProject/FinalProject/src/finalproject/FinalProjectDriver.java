/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Scanner;

/**
 *
 * @author Keigh
 */
public class FinalProjectDriver {
    public static void main(String[] args) {

        int MIN = 1;
        int MAX = 100;
        int MAXNUM = 3000;
        int startingVortex = MAX-1;
        int chosenNumber;
        
        Utility util = new Utility();
        Scanner scanUtil = new Scanner(System.in);
        Graph graph1 = new Graph(MAX);
        System.out.println("Search App");
        System.out.println("--------------------------------------------------");
        System.out.println("Notes: Drastically scaled down to 1000 nodes and 3,000 random\n" +
                           "numbers. With currrent graph implementation, \n" +
                           "this will not run with 100,000 nodes. Should probably have\n" +
                           "used a different data structure to create the graph.\n" +
                           "Not fully implemented: dijkstra Algorithm, as well as full\n" +
                           "100,000 nodes and 300,000 random integers\n");
                
        
        System.out.println("--------------------------------------------------");
        System.out.println("Please a number to search for:");
        chosenNumber = Integer.parseInt(scanUtil.nextLine());

        try
        {
            for(int i = 0; i < MAX; i++)
            {
                Node newNode = new Node(util.GenerateRandomNumber(MIN,MAXNUM));
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
            
            //insert non-random adjacent edge
            for(int i = 0; i < MAX; i ++)
            {
                int toVertex = util.GenerateRandomNumber(1, 5);
                int toVertexOffset = util.GenerateRandomNumber(1,(MAX/2));
                for(int j = 0; j <= toVertex; j++)
                {
                    graph1.insertEdge(i, (toVertex + toVertexOffset));
                }
            }
            
            System.out.println();
            System.out.println("Starting vortex " + (startingVortex) + "\n");
            System.out.println("Starting DFT for number:  " + chosenNumber + "\n");
            graph1.startDFT(startingVortex, chosenNumber);
            
            System.out.println();
            System.out.println("Starting BFT for number: " +  chosenNumber+ "\n");
            graph1.startBFT(startingVortex, chosenNumber);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }       
    }
}
