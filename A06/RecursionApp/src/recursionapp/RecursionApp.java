/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionapp;

/**
 *
 * @author Keigh
 */
public class RecursionApp {

    /**
     * @param args the command line arguments
     */
    
    public static int count = 0;
    public static int time = 0;
        
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(Fib(5));
        
        
        long n = 4;
        System.out.println(n + " Factorial is " + nFactorial(n));
    }
    
    
    public static int Fib(int i) {

        // Base Cases
        if (i <= 1) return 1;
        if (i == 2) return 2;

        // Recursion
        return Fib(i - 1) + Fib(i - 2);
    }
    
    public static long nFactorial(long n)
    {
        long value;
        count ++;
        time ++;
        
        System.out.println("at time " + time);
        System.out.println("\tnFactorial has been INVOKED for the " + count + 
                "th time, " + " with n = to " + n);
        
        if(n==0) //base case
        {
            time++;
            System.out.println("\nat Time " + time);
            System.out.println("\tRETURNING 0! = 1" + " from the " +
                   count-- + "th invocation of nFactorial");
            return 1;
        }
        else
        {
            System.out.println("\tnFactorial is INVOKING ITSELF with n = to " + 
                    (n - 1));
            value = n * nFactorial(n - 1);
            time++;
            System.out.println("at time " + time);
            System.out.println("\tRETURNING " + n + "! = " + value + " from the " 
                + count -- + "the invocation of nFactorial");

            return value;
        }
    }
}

