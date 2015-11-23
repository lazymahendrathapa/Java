import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class Sherlock
{
  public static void main(String args[])
  {

   Scanner in = new Scanner(System.in);
   int t = in.nextInt();


   for(int i=0; i<t; ++i)
   {

     int n = in.nextInt();

     if(n<3)
        System.out.print("-1");

     else
     { 
     
     int  x; 
     int  y=0;
     int z = n; 
     int flag = 0;

            while(true)
            {
              x = n%3;
              n -=5;

              ++y;
              if(n==0)
              {
                flag = 1;
                break;
              }

              if(x == 0)
                {
                  flag = 1; 
                   --y;
                   break;
                }

              if(n<0 && x !=0)
              {
                System.out.print("-1");
                break; 
              }
            }

        if(flag == 1)
        {
           x = (z-5*y)/3;
        
            for(int j = 0; j<x; ++j)
                    System.out.print("555");


            for(int j = 0; j<y; ++j)
                    System.out.print("33333");

        }

     }

     System.out.println();
   }



  }

}
