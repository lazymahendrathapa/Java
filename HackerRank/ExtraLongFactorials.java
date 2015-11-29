import java.util.*;
import java.math.*;

public class ExtraLongFactorials
{
  public static void main(String args[])
  {
   
          Scanner in = new Scanner(System.in);
          int n = in.nextInt();
   
          BigInteger res = new BigInteger("1");

          for(int i=n; i>1; --i)
          {
               res = res.multiply(new BigInteger(Integer.toString(i)));
          }

          System.out.println(res);


  }

}


