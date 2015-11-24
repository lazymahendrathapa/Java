import java.util.*;

public class ServiceLane
{


    public static void main(String args[])
    {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int width[] = new int[n];

        for(int i = 0; i<n; ++i)
            width[i] = in.nextInt();

        for(int z=0; z<t; ++z)
        {
            int i = in.nextInt();
            int j = in.nextInt();

            int temp[] = new int[j-i+1];

            int l = i;
            for(int k=0; k<temp.length; ++k)
            {
                temp[k] = width[l];
                ++l

            }

            Arrays.sort(temp);


            System.out.println(temp[0]);
        }

    }
}
