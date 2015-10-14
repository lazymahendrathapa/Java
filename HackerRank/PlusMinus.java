import java.io.*;
import java.util.*;
import java.text.*;

public class PlusMinus
{
    public static void main(String []args)
    {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int posCount=0;
        int negCount=0;
        int zeroCount=0;

        for(int i=0; i<a; ++i)
        {

           int b = scanner.nextInt();

           if(b>0)
            ++posCount;
           else if(b<0)
            ++negCount;
           else 
             ++zeroCount;
        }


        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);

        System.out.println(df.format((float)posCount/(posCount+negCount+zeroCount)));
        System.out.println(df.format((float)negCount/(posCount+negCount+zeroCount)));
        System.out.println(df.format((float)zeroCount/(posCount+negCount+zeroCount)));


    }

}
