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
   public boolean insert(Node newStudentData)
   {
       int low = 0;
       int high = _next - 1;
       int i = (low + high)/2;

      
       //clean this up later
        if (_studentData[1] == null)
        {
            if (_studentData[0] == null)
            {
                _studentData[0] = newStudentData.deepCopy();
            }
            else if (newStudentData.getStudentName().compareTo(_studentData[0].getStudentName()) < 0)
            {
                Node tempNode = _studentData[0].deepCopy();
                _studentData[0] = newStudentData.deepCopy();
                _studentData[1] = tempNode.deepCopy();   
            }else
            {
                _studentData[1] = newStudentData.deepCopy();
            }

            _next = _next + 1;
            return true;
        }

       while(!(newStudentData.getStudentName().compareTo(_studentData[i].getStudentName()) < 0 && 
               newStudentData.getStudentName().compareTo(_studentData[i - 1].getStudentName()) > 0 ))
       {
           if(newStudentData.getStudentName().compareTo(_studentData[i].getStudentName()) < 0)
           {
               high = i - 1;
           }else
           {
              low = i + 1;   
           }
           
           i = (high + low) / 2;
        }
        
        //move references down
       for(int j = _next; j >= i; j--)
       {
           _studentData[j] = _studentData[j - 1];
       }
       _next = _next + 1;
       _studentData[i] = newStudentData.deepCopy();
       
       return true; //inserted
   }
    
   public Node fetch(String targetKey)
   {
       int low = 0;
       int high = _next - 1;
       int i = (low + high)/2;
       
       while(!(targetKey.equals(_studentData[i].getStudentName())))
       {
           //if((targetKey.compareTo(_studentData[i].getName()&& high != low)
           if((targetKey.compareTo(_studentData[i].getStudentName()) < 0) && high != low)
           {
               high = 1 - 1;
           }else
           {
              i = (low + high)/2;     
           }
        }
       return _studentData[i].deepCopy();
   }
   
   public boolean delete(String targetKey)
   {
       int low = 0;
       int high = _next - 1;
       int i = (low + high)/2;
       
       while(!(targetKey.equals(_studentData[i].getStudentName())) && high != low)
       {
           if(targetKey.compareTo(_studentData[i].getStudentName()) < 0)
           {
               high = i - 1;
           }else
           {
               low = i + 1;
           }
           
           i = (low = high) / 2;
       }
       
       //move references up
       for(int j = 1; j < _next-1; j++)
       {
           _studentData[j] = _studentData[j + 1];
       }

       _next = _next - 1;
       _studentData[_next ] = null; 
       
       return true; //deleted
   }
   

   public boolean update(String targetKey, Node nodeToUpdate)
   {
       if (delete(targetKey) == false)
       {
           return false; //does not exist
       }
       else if (insert(nodeToUpdate) == false)  //this will perform the deepCopy from nodeToUpdate
       {
           return false; //not big enough for new entry
       }
       return true; //success
   }
   
   public void showAll(){
       //all records
        for (int i = 0; i < _studentData.length - 1; i++)
        {
            System.out.println(_studentData[i]);
        }
   }
   
   @Override
   public String toString(){
       //all records
       String returnString = "";
        for (int i = 0; i < _studentData.length - 1; i++)
        {
            if (!(_studentData[i] == null))
            {
                returnString += "Student: " + _studentData[i].toString() + "\n";
            }
        }
        
        return returnString;
   }
}
