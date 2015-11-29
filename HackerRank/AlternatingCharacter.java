import java.util.*;
import java.util.regex.*;

public class AlternatingCharacter
{

  public static void main(String args[])
  {

         Scanner in = new Scanner(System.in);
         int t = in.nextInt();
         
         Pattern pat;
         Matcher mat;
         boolean found;


         for(int j=0; j<t; ++j)
         {
           String input = in.next();
           
           boolean flag1 = true;
           boolean flag2 = true;
 
           StringBuilder res1 = new StringBuilder();
           StringBuilder res2 = new StringBuilder();

          if(!input.contains("A") || !input.contains("B"))
            System.out.println(input.length()-1);
          else
            {

           res1.append("A");
           res2.append("B");

           for(int i=1; i<input.length(); ++i)
           {
             if(flag1 && input.charAt(i) == 'B' && i>=input.indexOf("A"))
             {
                flag1 = false;
                res1.append(Character.toString(input.charAt(i)));
             }
             else if( !flag1 && input.charAt(i) == 'A')
                {
                  flag1 = true;
                res1.append(Character.toString(input.charAt(i)));
            
                }

             if(flag2 && input.charAt(i) == 'A' && i>=input.indexOf("B"))
             {
                flag2 = false;
                res2.append(Character.toString(input.charAt(i)));
             }
             else if( !flag2 && input.charAt(i) == 'B')
                {
                  flag2 = true;
                res2.append(Character.toString(input.charAt(i)));
            
                }
           }


             if(res1.length()>res2.length())
             {
                System.out.println(input.length() - res1.length());
             }
             else
            {

                System.out.println(input.length() - res2.length());
            }
        }
    }

  }

}
