import java.util.*;

public class InsertionSort1{
  public static void main(String args[]){

    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; ++i)
        arr[i] = in.nextInt();

    for(int i=0; i<n; ++i){
     for(int j=i+1; j<n; ++j){
       
            if(arr[i]>arr[j]){

             int temp = arr[j]; 
             for(int k=j ; k>i; --k){
                arr[k] = arr[k-1];
                print(arr);
              }

                arr[i] = temp;
                print(arr);
             
             }
            
            }
            
     }
    }



static  void print(int[] arr)
  {
     for(int i: arr)
            System.out.print(i+" ");

     System.out.println();
  }
}

