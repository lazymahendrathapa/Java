import java.util.*;

public class CutTheSticks
{
  public static void main(String args[])
  {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i<n; ++i)
            arr.add(in.nextInt());


        while(arr.size()>0)
        {

                Collections.sort(arr);


                for(int i=arr.size()-1; i>=0;--i)
                    arr.set(i,arr.get(i)-arr.get(0));


                 System.out.println(arr.size());

                 
                 while(arr.contains(0))
                 {
                     arr.remove(Integer.valueOf(0));
                 }

                 System.out.println(arr);
                 
        }

                  
        }



  

}
