/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasheddatastructuresapp;

/**
 *
 * @author Keigh
 */
public class HashedDataStructuresApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int knownFourKPlus3 = 6659;
        
        
    }
    
    public static int fourKPlus3(int n, int pct)
    {
        boolean fkp3 = false;
        boolean aPrime = false;
        int prime;
        int highDivisor;
        int d;
        double pctd = pct;
        
        prime = (int)(n *(1.0 + (pctd / 100.0)));
        
        if(prime % 2 == 0)
        {
            prime = prime + 1;
        }
        
        while(fkp3 == false)
        {
            while(aPrime == false)
            {
                highDivisor = (int)(Math.sqrt(prime) + 0.5);
                for(d = highDivisor; d > 1; d--)
                {
                    if(prime % d == 0)
                    {
                        break; //not prime
                    }
                }
                if( d != 1)
                {
                    prime = prime + 2;
                }
                else
                {
                    aPrime = true;
                }
            } //end of Prime Search
            
            if((prime - 3) % 4 == 0) //should have no remainder
            {
                fkp3 = true;
            }
            else
            {
                prime = prime + 2;
                aPrime = false;
            }
        }
        
        return prime;
    }
   
}
