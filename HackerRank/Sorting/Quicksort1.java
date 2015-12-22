import java.util.*;

public class Quicksort1{
 
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


     }

     public static int partition(int[] arr,int start,int end){


            int pivot = arr[end];
            int pIndex = start;

            for(int i=start; i<end; ++i){

               if(arr[i] <= pivot){

                  swap(arr,i,pIndex);
                  ++pIndex;
               }

            }

               swap(arr,pIndex,end);
               return pIndex;
     }

     public static void swap( int[] arr, int a, int b){

             int temp = arr[b];
             arr[b] = arr[a];
             arr[a] = temp;
     }

}



