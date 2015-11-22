import java.util.*;

public class MergeSort2
{

    private static int array[];
    private static int length;
    private static int temp[];

    public static void main(String []args)
    {

    MergeSort2 mms = new MergeSort2();
    mms.takeInput();
    mms.mergeSort(0,length-1); 
    mms.printOutput(); 
    
    }
   
    void mergeSort(int p, int r)
    {
       if(p<r)
       {
           int q = p + (r-p)/2;
           mergeSort(p,q);
           mergeSort(q+1,r);
           mergeParts(p,q,r);
       }
    }

    void mergeParts(int p, int  q, int r)
        {
            for(int i=p; i<=r; ++i)
                    temp[i] = array[i];

            int i=p;
            int j = q+1;
            int k = p;

            while(i<=q && j<=r)
            {
               if(temp[i]<=temp[j])
               {
                    array[k] = temp[i];
                    ++i;
               }
               else
               {
                   array[k] = temp[j];
                    ++j;
               }

               ++k;

            }

            while(i<=q)
            {
              array[k] = temp[i];
              ++i;
              ++k;
            }
        
        }


    void takeInput()
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your length: ");
    length = scanner.nextInt();

    array = new int[length];
    temp = new int[length];

    System.out.println("Enter array: ");

    for(int i=0; i<length; ++i)
    {
          array[i] = scanner.nextInt();
    }

    }

    void printOutput()
    {
       for(int i:array)
        System.out.println(i);

    }
}
