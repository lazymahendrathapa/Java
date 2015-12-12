import java.util.*;

public class MorganAndString
{

 public static void main(String args[])
 {
  
   Scanner in = new Scanner(System.in);

   int t = in.nextInt();

   for(int i=0; i<t; ++i)
   {
    
        String first = in.next();
        String second = in.next();


         int j=0;
         int k=0;
         
         StringBuilder answer = new StringBuilder();

        while(j<first.length() || k<first.length() )
         {
 
     
                 
         
         if(j<first.length() && k<second.length())
            {
        
        if(!Character.isUpperCase(first.charAt(j)))
         {
             ++j;
             continue;
         }
         else if(!Character.isUpperCase(second.charAt(k)))
         {
              ++k;
              continue;
         } 
         
          if(first.charAt(j) < second.charAt(k))
                {
                  answer.append(Character.toString(first.charAt(j)));
                  ++j;
                }
                else
                {
                    answer.append(Character.toString(second.charAt(k)));
                    ++k;
                }
            }

            else if(j<first.length())
            {
                 answer.append(first.substring(j,first.length()));
                 break;
            }
            else if(k<second.length())
            {
                 answer.append(second.substring(k,second.length()));
                 break;
            }
         }


         System.out.println(answer);

   }

 }

}
