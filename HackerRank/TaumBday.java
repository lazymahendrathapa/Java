import java.util.*;

public class TaumBday
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for(int i = 0; i<t; ++i)
    {
       long b = in.nextInt(); //x
       long w = in.nextInt(); //y
       long x = in.nextInt();
       long y = in.nextInt();
       long z = in.nextInt();

       long temp1 = b*x + w*y;
       long temp2 = b*(y+z) + w*y;
       long temp3 = b*x + w*(x+z);

       if(temp1 <= temp2 && temp1 <=temp3)
               System.out.println(temp1);
       else
       {
           if(temp2<temp3)
                System.out.println(temp2);
           else
               System.out.println(temp3);

       }
   }

  }

}
