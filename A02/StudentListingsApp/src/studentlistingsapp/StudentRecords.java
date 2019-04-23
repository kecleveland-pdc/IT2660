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
   private int _next;
   private int _size;
   private Listing[] _studentData;
   
   public StudentRecords()
   {
       _next = 0;
       _size = 100;
       _studentData = new Listing[_size];
   }
   
   public StudentRecords(int size)
   {
       _next = 0;
       _studentData = new Listing[size];
       _size = size;
   }
   
    //INSERT 
   public boolean insert(Listing newStudentData)
   {
       int low = 0; //lower bound
       int high = _next - 1; //upper bound
       int i = (low + high)/2; //starting mid
       
       //resize array
       if(_next >= _size)
       {
           _size = _size+1;
           
           Listing tempStudentData[] = _studentData;
           Listing expandedStudentData[] = new Listing[_size];
           _studentData = expandedStudentData;
           
           for(int k = 0; k < tempStudentData.length-1; k++)
           {
               _studentData[k] = tempStudentData[k];  
           }
           
           tempStudentData = null;
           expandedStudentData = null;
       }
       
       //TODO FIX INSERT
       while(!( newStudentData.getStudentName().compareTo(_studentData[i].getStudentName()) < 0 &&  //if it's not NOT equal (ie != 0)
               newStudentData.getStudentName().compareTo( _studentData[i-1].getStudentName()) > 0))
       {   
           if(newStudentData.getStudentName().compareTo(_studentData[i].getStudentName()) < 0) 
           {
               high = i-1; // remove upper half since newStudentData is in lower half
           }
           else
           {
               low  = i+1;   //remove lower half since newStudentData is in upper half
           }
           i = (low + high)/2; //new mid
       }
       //found the actual key
        for(int j = _next; j >= i; j--)
           {
              _studentData[j] = _studentData[j-1];
           }
           
           _next = _next + 1;
           _studentData[i] = newStudentData.deepCopy();
       
       return true; //inserted
   }
    
   public Listing fetch(String targetKey)
   {
       int low = 0;
       int high = _next - 1;
       int i = (low + high)/2;
       
       while(!(targetKey.equals(_studentData[i].getStudentName())))
       {
           if((targetKey.compareTo(_studentData[i].getStudentName()) < 0) && high != low)
           {
               high = 1 - 1;
           }else
           {
              i = (low + high)/2;     
           }
           i = (low + high)/2; //new mid
        }
       return _studentData[i].deepCopy();
   }
   
   public boolean delete(String targetKey)
   {
       int low = 0;
       int high = _next - 1;
       int i = (low + high)/2;
       
       if(_next <= _size)
       {
           //decrease size of arraay
           _size = _size-1;
           
           Listing tempStudentData[] = _studentData;
           Listing expandedStudentData[] = new Listing[_size];
           _studentData = expandedStudentData;
           
           for(int k = 0; k < tempStudentData.length-1; k++)
           {
               _studentData[k] = tempStudentData[k];  
           }
           
           tempStudentData = null;
           expandedStudentData = null;
       }
       
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
   

   public boolean update(String targetKey, Listing nodeToUpdate)
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
