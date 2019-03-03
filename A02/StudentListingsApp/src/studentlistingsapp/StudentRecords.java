/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlistingsapp;

/**
 *
 * @author Keigh
 */
public class StudentRecords 
{
   private Node[] _studentData;
   private int _next;
   private int _size;
   
   public StudentRecords()
   {
       _next = 0;
       _size = 100;
       _studentData = new Node[_size];
   }
   
    public StudentRecords(int size)
   {
       _next = 0;
       _studentData = new Node[size];
       _size = size;
   }
  
    //INSERT
   public boolean insert(Node newStudentData) //boolean to return insert result
   {
       if (_next >= _size) //if there is no room to insert bc array is full
       {
           return false; //no insert possible
       }
       
       _studentData[_next] = newStudentData.deepCopy(); //create a deep copy
       
       if(_studentData[_next] == null) //if the next node does not exist, then end of array
       {
           return false; // end of insert
       }
       
       _next = _next + 1; //set next to the new next
       return true; //insert possible
   }
   
   public boolean delete(String targetKey)
   {
       int i = 0;
       
       while(i < _next && !(_studentData[i].getName().compareTo(targetKey) == 0))
       {
           i++; //keep incrementing until finding match
       }
       
       if(i == _next)
       {
           return false;
       }
       
       //swap for last position
       _studentData[i] = _studentData[_next - 1];
       _studentData[_next - 1] = null; 
       _next = _next - 1;
       
       return true; //deleted
   }
    
   public boolean update(String targetKey, Node nodeToUpdate)
   {
       if (delete(targetKey) == false)
       {
           return false; //does not exist
       }
       else if (insert(nodeToUpdate) == false)  //thos will perform the deepCopy from nodeToUpdate
       {
           return false; //not big enough for new entry
       }
       return true; //success
   }
    
  //FETCH
   public Node fetch(String targetKey)
   {
       Node curNode;
       Node tempNode;
       
       int i = 0; //starting
       
       while(i < _next && !(_studentData[i].getName().compareTo(targetKey) == 0))
       {
           i++;
       }
       
       if (i == _next)
       {
           return null;
       }
       
       curNode = _studentData[i].deepCopy(); //deep copy
       
       if(i !=0)
       {
          //swapping function
         tempNode = _studentData[i-1];    //tempNode = _studentData[i-1]; --> tempNode = _studentData[1-1]; == _studentData[0]  
         _studentData[i-1] = _studentData[i]; // _studentData[0]  = _studentData[1] 
         _studentData[i] = tempNode;  // _studentData[1] = tempNode[0]
       }
           
       return curNode; //placeholder
   }

}
