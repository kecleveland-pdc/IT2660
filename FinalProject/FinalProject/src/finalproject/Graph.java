/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Keigh
 */
public class Graph {
    Node vertex[];
    int edge[][];
    int max;
    int numberOfVertices;
    
    public Graph(int vertexValue)
    {
        vertex = new Node[vertexValue];
        edge = new int[vertexValue][vertexValue];
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
        
        edge[fromVertex][toVertex] = 1; //eg. [0][1]
        return true;
    }
    
    public void showVertex(int vertexNumber)
    {
        System.out.println(vertex[vertexNumber]);
    }
    
    public  void showEdges(int vertexNumber)
    {
        for(int column = 0; column < numberOfVertices; column++)
        {
            if(edge[vertexNumber][column] == 1) //this is an edge
            {
                System.out.println(vertexNumber + ", " + column);
            }
        }
    }
}
