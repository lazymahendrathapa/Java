import java.util.*;

public class Quicksort2{
 
    public static void main(String args[]){

       Scanner in = new Scanner(System.in);
       
       int n= in.nextInt();
       int[] arr = new int[n];

        for(int i=0; i<n; ++i)
        arr[i] = in.nextInt();

        sorting(arr, 0,n-1);
        
        for(int i:arr)
            System.out.print(i + " ");
         
    }

     public static void sorting(int[] arr,int start,int end){

            if(start>=end)
                return;


            int pIndex = partition(arr,start,end);
            sorting(arr,start,pIndex-1);
            sorting(arr,pIndex+1,end);

               for(int i=start; i<=end; ++i)
                    System.out.print(arr[i] + " ");

                    System.out.println(" ");



     }

     public static int partition(int[] arr,int start,int end){


            int pivot = start;

            for(int i=start; i<=end; ++i){

               if(arr[i] < arr[pivot]){

                    int temp = arr[i];

                    for(int j=i; j>pivot; --j)
                        arr[j] = arr[j-1];

                    arr[pivot] =temp;

                    ++pivot;
               }

            }

               return pivot;
     }

     public static void swap( int[] arr, int a, int b){

             int temp = arr[b];
             arr[b] = arr[a];
             arr[a] = temp;
     }

}



