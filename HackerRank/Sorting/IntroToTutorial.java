import java.util.*;

public class IntroToTutorial{

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int n = in.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; ++i)
            arr[i] = in.nextInt();

        for(int i=0; i<n; ++i)
            if(arr[i] == v)
            {
               System.out.println(i);
               break;
            }
    }


}
