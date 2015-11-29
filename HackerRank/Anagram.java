import java.util.*;

public class Anagram
{
  public static void main(String args[])
  {
   Scanner in = new Scanner(System.in);

   int n = in.nextInt();

   
   for(int k=0; k<n; ++k)
   {
    
     String input = in.next();


     int total = 0;

     if(input.length()%2 !=0)
     {
         System.out.println(-1);
     }
     else
     {
             StringBuilder first = new StringBuilder(input.substring(0,input.length()/2));
             StringBuilder second = new StringBuilder(input.substring(input.length()/2, input.length()));

             int length = first.length();

             int i=0;

             while(true)
             {
            
               if(i>=first.length())
               break;

               if(second.toString().contains(Character.toString(first.toString().charAt(i))))
               {  
               
                  second.deleteCharAt(second.indexOf(Character.toString(first.toString().charAt(i))));
                  first.deleteCharAt(i);

                  i=0;
                  ++total;

               }
               else
               {
                  ++i;
               }


             }

                
     System.out.println(length - total);
     
     }



   }

  }

}
