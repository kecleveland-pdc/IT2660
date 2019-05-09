/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.util.Stack; 
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 *
 * @author Keigh
 */
public class Graph {
    //graph specific
    Node vertex[];
    Utility util;
    ArrayList<Integer> nodeArrList;
    
  
    int edge[][]; //int edge[][]; //adjacency matrix array 2-dim array 
    int edgeWeight[][];
    int spTree[][]; //adjacency matrix array for sp
    int mSPTree[][];
    int wMatrix[][]; //weight matrix
    
    //tree arrays for dj
    int[] verticesIncluded;
    int[][] arrCopy; 
    int[] minPathLengths;
    
    int max;
    int numberOfVertices;
    int numVerticesIncluded;
    
    public Graph(int vertexValue)
    {
        vertex = new Node[vertexValue];
        util = new Utility();
        nodeArrList = new ArrayList<>();
        edge = new int[vertexValue][vertexValue];
        edgeWeight = new int[vertexValue][vertexValue];
        max = vertexValue; 
        numberOfVertices = 0;
    }
    
    public boolean insertVertex(int vertexNumber, Node newNode)
    {
        if(vertexNumber >= max) //full!
        {
            return false;
        }
        
        vertex[vertexNumber] = newNode.deepCopy();
        numberOfVertices++; 
        
        return true;
    }
    
    public boolean insertEdge(int fromVertex, int toVertex)
    {
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
        {
            return false; //does not exist
        }
        if( edgeWeight[fromVertex][toVertex] >= 1)
        {
            return false;
        }
        
        edge[fromVertex][toVertex] = 1; //eg. [0][1]
        edgeWeight[fromVertex][toVertex] = util.GenerateRandomNumber(1,20);
        System.out.println("Added edge at Vertex[" + fromVertex + "][" + toVertex + "] with weight: " + edgeWeight[fromVertex][toVertex]);
        
        return true;
    }
    
    public void showVertex(int vertexNumber)
    {
        System.out.println(vertex[vertexNumber].getNode());
    }
    
    public void showEdges(int vertexNumber)
    {
        for(int column = 0; column < numberOfVertices; column++)
        {
            if(edge[vertexNumber][column] == 1) //this is an edge
            {
                System.out.println(vertexNumber + ", " + column);
            }
        }
    }
    
    public void startBFT(int firstVertex, int chosenNumber)
    {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            {
                vertex[i].setPushed(false); //basically nothing has been visited yet
            } 
        }
        
        queue.add(firstVertex);

        try
        {
            while(queue.size() != 0) //not empty
            {
                int nextNode;
                nextNode = queue.remove(); //dequeue
            
                if(!visited.contains(nextNode))
                {
                    visited.add(nextNode); //visited
                    System.out.println("Traveled to: Vertex [" + nextNode + "] with value of: " + vertex[nextNode].getNode()); //show visited
                    if(vertex[nextNode].getNode() == chosenNumber)
                    {
                        System.out.println("Found " + chosenNumber + " at Vertex[" + nextNode + "]. Exiting...");
                        break;
                    }
                    
                    for(int i = 0; i < numberOfVertices; i++)
                    {
                        if(edge[nextNode][i] > 0 && !visited.contains(i)) //if edge and not visited 
                        {
                            queue.add(i); //add to queue 
                        }
                    }
                } 
            }
            
            if(queue.isEmpty())
            {
                System.out.println("Failed. Did not find " + chosenNumber + " with this search.");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.toString());
        } 
    }
    
    public void startDFT(int firstVertex, int chosenNumber)
    {
        int visited;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            {
                vertex[i].setPushed(false); //basically nothing has been visited yet
            }
        }
        
        stack.push(firstVertex); //first visited
        vertex[firstVertex].setPushed(true); //has been visited
        try
        {
            while(!stack.empty())
            {
                visited = stack.pop(); //returns object
                vertex[visited].visit(visited); //visit vertex (ie show)
            
                //FIND THE NUMBER
                if(vertex[visited].getNode() == chosenNumber)
                {
                    System.out.println("Success! Found " + chosenNumber + " at Vertex[" + visited + "]. Exiting...");
                    break;
                }
            
                for(int column = 0; column < numberOfVertices; column++)
                {
                    if(edge[visited][column] == 1 && !vertex[column].getPushed()) //is edge and not already visited
                    {
                        stack.push(column);
                        vertex[column].setPushed(true);
                    }
                }
                
            }
            
            if(stack.isEmpty())
            {
                System.out.println("Failed. Did not find " + chosenNumber + " with this search.");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.toString());
        }
    }
    
    public int[][] dijkstra(int startingVertex)
    {
        int numVericesIncluded;
        int[] minPathLengths = new int[numberOfVertices];
        int[] verticesIncluded = new int[numberOfVertices];
        int[][] wMatrixCopy = wMatrix;
        int noEdge = Integer.MAX_VALUE; //not sure
        int noPath = Integer.MAX_VALUE;
        int minPath;
        
        int rowMin = 0; //edge row
        int colMin = 0; //edge column
        int weightMin = 0; //weighting factor
        int minWeight = 0;
        
        verticesIncluded[0] = startingVertex; //start at starting vertex
        numVericesIncluded = 1; //at least one has been added now
        
        for(int i = 0; i < numberOfVertices; i++)
        {
            minPathLengths[i] = noPath; //initializes path lengths to impossible
            wMatrixCopy[i][startingVertex] = noEdge; //gets rid of all edges
        }
        
        minPathLengths[startingVertex] = 0;
        
        while(numVericesIncluded < numberOfVertices)
        {
           minPath =  findMinWeightEdge(numberOfVertices, wMatrixCopy, verticesIncluded, numVerticesIncluded, 
                                        rowMin, colMin, weightMin);
            
            for(int i = 0; i < numberOfVertices; i++)
            {
                wMatrixCopy[i][colMin] = noEdge; //eliminate all other vertices
            }
            
            spTree[rowMin][colMin] = minWeight;
            spTree[colMin][rowMin] = minWeight;
            minPathLengths[colMin] = minPath;
            verticesIncluded[numVerticesIncluded] = colMin;
            
            numVerticesIncluded++;
        }
        
        return spTree;
    }
     
     //findMinDist distance method
    public int findMinWeightEdge(int numberOfVertices, int [][] arrCopy,  int[] verticesIncluded, int numVerticesIncluded,
                            int rowMin, int colMin, int weightMin)
    {
        int index = -1; //fake index to show shouldn't be considered
        return index;  //keep because this is final 
    }
    
}
