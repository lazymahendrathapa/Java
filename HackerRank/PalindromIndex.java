import java.util.*;

public class PalindromIndex
{
  public static void main(String args[])
  {
   Scanner in = new Scanner(System.in);

   int n = in.nextInt();

   for(int i=0; i<n; ++i)
   {
      StringBuilder input = new StringBuilder(in.next());
      StringBuilder temp =  new StringBuilder(input.toString()); 

      if(input.toString().equals(temp.reverse().toString()))
      {
            System.out.println(-1);
      }
      
      else
      {
        for(int j=0; j<input.length()/2; ++j)
        {
          if(input.charAt(j) != input.charAt(input.length()-1-j))
          {
           
             int length = input.length();
             input.deleteCharAt(j);

              StringBuilder tem = new StringBuilder(input.toString()); 
        if(input.toString().equals(tem.reverse().toString()))
            System.out.println(j);
        else
            System.out.println(length -1-j);

             break;
          }
        }

      }

   }

  }

}
