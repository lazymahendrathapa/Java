import java.util.*;

public class RunningTime{
  public static void main(String args[]){

    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; ++i)
        arr[i] = in.nextInt();


    int count = 0;
    for(int j=1; j<n; ++j){
  
       int key = arr[j];
       int i = j-1;

       while(i>=0 && arr[i]>key){
           arr[i+1] = arr[i];
           --i;
           ++count;
        }
       arr[i+1] = key;

     }

    System.out.println(count);
    }




}

