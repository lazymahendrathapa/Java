import java.util.*;

public class GemStones
{
   public static void main(String args[])
   {

     Scanner in = new Scanner(System.in);

     int n = in.nextInt();
     String[] input = new String[n];


     for(int i=0; i<n; ++i)
            input[i] = in.next();

     for(int i=0; i<n; ++i)
            input[i] = input[i].replaceAll("[^a-z]","");

     int total = 0;

     Set<String> first = new HashSet<String>();

     for(int i = 0; i<input[0].length();++i)
     {
          first.add(Character.toString(input[0].charAt(i)));
     }

    for( String temp: first)
    {

      boolean flag = true;

      for(int j=0; j<n; ++j)
      {

       if(!(input[j].contains(temp)))
       {
          flag = false;
          break;
       }

      }

      if(flag)
        ++total;

    }

    System.out.println(total);

   }
}

