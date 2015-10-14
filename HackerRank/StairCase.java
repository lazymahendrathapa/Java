import java.util.*;

public class StairCase
{

public static void main(String [] args)
{

    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();

    for(int i=0; i<a; ++i)
    { 
        for(int k = a-i-1; k>=0; --k)
            System.out.print(" ");


        for(int j=0; j<=i; ++j)
        { 
           System.out.print("#");

         }
      System.out.println();
    }

}

}
