import java.util.*;

class Answer
{
 int i,j,sum;

 Answer(int i, int j, int sum)
 {
   this.i = i;
   this.j = j;
   this.sum = sum;
 }
}

class MaximumSubarray
{
  public static void main(String args[])
  {

    int array[] = {1,-3,2,-5,7,6,1,4,11,-23};
    int length = array.length;

    Answer ans = findMaximumSubArray(array, 0, length-1);

    System.out.println(ans.i + " " + ans.j+" " +ans.sum);
  }


 static Answer findMaximumSubArray(int array[], int low, int high)
  {
    if(low==high)
    {
        Answer ret = new Answer(low,high,array[low]);
        return  ret;
    }
    else
    {
       int mid = (low+high)/2;
       Answer left = findMaximumSubArray(array,low,mid);
   //    System.out.print("left: "); 
   //    display(left);
       Answer right = findMaximumSubArray(array,mid+1,high);
   //    System.out.print("right: "); 
   //    display(right);
       Answer cross = findMaxCrossingSubArray(array,low,mid,high);
   //    System.out.print("cross: "); 
   //    display(cross);
       if(left.sum >=right.sum && left.sum >=cross.sum)
          return left;
       else if(right.sum >= left.sum && right.sum >=cross.sum)
            return right;
       else return cross;

    }
 
  }

 static void display(Answer ans)
 {
        System.out.println(ans.i + " " + ans.j + " " + ans.sum);
  }

 static  Answer findMaxCrossingSubArray(int array[], int low, int mid, int high)
  {
    int left_sum = -100000000;
    int sum = 0;
    int i;
    int max_left=0; 
    int max_right=0;

    for(i=mid; i>=low; --i)
    {
     sum +=array[i];

     if(sum>left_sum)
     {
     left_sum = sum;
     max_left = i;
     }
    }

    int right_sum = -100000000;

    sum = 0;

    for( i = mid +1; i<=high;++i)
    { 
    sum +=array[i];

    if(sum>right_sum)
    {
    right_sum = sum;
    max_right = i;
    }

    }
    Answer ret = new Answer(max_left,max_right, left_sum + right_sum);

    return ret;
  }

}
