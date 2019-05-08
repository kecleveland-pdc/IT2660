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

        int MIN = 1;
        int MAX = 5;
        Graph graph1 = new Graph(MAX);
        
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
                    System.out.println("Inserted " + newNode.getNode() + " at Vertex " + i + "\n");
                }      
            }
            
            //insert non-random edges
            graph1.insertEdge(0,1);
            graph1.insertEdge(1,2);
            graph1.insertEdge(1,3);
            graph1.insertEdge(2,4);
            
//            for(int i = 0; i < graph1.numberOfVertices; i++)
//            {
//                System.out.print("Vertex " + i + "'s node value is ");
//                graph1.showVertex(i);
//                System.out.println("This vertex has edges at: ");
//                graph1.showEdges(i);
//                System.out.println("\n");
//            }
            
            System.out.println("Start DFT at Vertex 0\n");
            graph1.startDFT(0);
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
