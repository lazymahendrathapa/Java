import java.util.*;

public class FindDigits
{

    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

       
        for(int i = 0; i<t; ++i)
        {
            int result = 0;
            int n = in.nextInt();
            int z = n;

            ArrayList<Integer> al = new ArrayList<Integer>();

             while(n>0)
             {
               al.add(n%10);
               n /=10;

             }

            for(int k: al)
             {

               if(k == 0)
                    continue;

               if(z%k == 0)
                ++result;

             }

            System.out.println(result);

        }
        

    }

}
