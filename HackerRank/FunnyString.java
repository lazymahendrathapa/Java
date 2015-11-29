import java.util.*;

public class FunnyString
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for(int j = 0; j<t; ++j)
    {

            String string = in.next();
            String reverse = new StringBuilder(string).reverse().toString();

            boolean flag= true;

            for(int i=1; i<string.length(); ++i)
            {
               if(!(Math.abs((int)string.charAt(i)-(int)string.charAt(i-1))==Math.abs((int)reverse.charAt(i)-(int)reverse.charAt(i-1))))
               {
                  flag = false;
                  break;
               }
            }

            if(flag)
                System.out.println("Funny");
            else
                System.out.println("Not Funny");

    }

  }


}
