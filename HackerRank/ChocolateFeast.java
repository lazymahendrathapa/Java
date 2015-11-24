import java.util.*;

public class ChocolateFeast
{
  public static void main(String args[])
  {
     Scanner in = new Scanner(System.in);
     int t = in.nextInt();

     for(int i=0; i<t; ++i)
     {
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();

        int chocolate = n/c;

        int z = chocolate;
          
         while(z-m>=0)
         {

               ++chocolate;
               z -=m;
               ++z;
         }

         System.out.println(chocolate);
     }


  }

}
