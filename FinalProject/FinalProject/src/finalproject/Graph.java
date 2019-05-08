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
    Node vertex[];
    int edge[][]; //adjacent matrix array
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
    
    public void startBFT(int firstVertex)
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
                    System.out.println("Vertex [" + nextNode + "]" ); //show visited
                
                    for(int i = 0; i < numberOfVertices; i++)
                    {
                        if(edge[nextNode][i] > 0 && !visited.contains(i)) //if edge and not visited 
                        {
                            queue.add(i); //add to queue 
                        }
                    }
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error " + ex.toString());
        }
        
    }
    
    public void startDFT(int firstVertex)
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
        
        while(!stack.empty())
        {
            visited = stack.pop(); //returns object
            vertex[visited].visit(visited); //visit vertex (ie show)
            
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[visited][column] == 1 && !vertex[column].getPushed()) //is edge and not already visited
                 {
                    stack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }
}
