import java.util.*;

public class LibraryFine
{

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();

        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();

        int result;

        if (y1<y2)
        {
           result = 0;

        }
        else if(y2 == y1)
        {

          if(m1<m2)
          {
             result = 0;   
          }
          else if(m1 == m2)
          {
             if(d1<=d2)
               {
                 result = 0;

               }
               else 
               {
                   result = 15 * (d1-d2);
               }
          }
          else
          {
            result = 500 * (m1-m2);
          }

        }
        else 
        {

            result = 10000;

        }

        System.out.println(result);
    }


}
