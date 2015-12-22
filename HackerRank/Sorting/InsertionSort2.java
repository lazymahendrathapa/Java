import java.util.*;

public class InsertionSort2{
  public static void main(String args[]){

    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; ++i)
        arr[i] = in.nextInt();


    for(int j=1; j<n; ++j){
  
       int key = arr[j];
       int i = j-1;

       while(i>=0 && arr[i]>key){
           arr[i+1] = arr[i];
           --i;
        }
       arr[i+1] = key;

                print(arr);
     }
    }



static  void print(int[] arr)
  {
     for(int i: arr)
            System.out.print(i+" ");

     System.out.println();
  }
}

