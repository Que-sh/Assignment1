import java.util.Scanner;
class factorial
{
   static int factorial(int n)
   {
       if(n==0 || n==1)
       {
           return 1;/*If n is o or 1*/
       }
       return n*factorial(n-1);/*Returning the factorial*/
   }
   public static void main(String[] args)
   {
       int n;
       Scanner scnr=new Scanner(System.in);/*Scannerobject*/
       System.out.print("Enter a number N:");
       n=scnr.nextInt();/*Reading user input*/
       System.out.print("N!"+"=" + factorial(n));
       /*printing the factorial*/
   }
}