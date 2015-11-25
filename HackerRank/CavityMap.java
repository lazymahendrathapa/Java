import java.util.*;

public class CavityMap
{

 public static void main(String args[])
 {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    StringBuilder grid[] = new StringBuilder[n];
    StringBuilder result[] = new StringBuilder[n];

    for(int i = 0; i<n; ++i)
         grid[i] = new StringBuilder(in.next());

    for(int i=0; i<n; ++i)
        result[i] = new StringBuilder(grid[i]);


    for(int i = 1; i<(n-1); ++i)
    {
    
    for(int j=1; j<(n-1);++j)
     {
    
       boolean isCavity = true;
     
       int value =  Integer.parseInt(Character.toString(grid[i].charAt(j)));

        if(Integer.parseInt(Character.toString(grid[i-1].charAt(j))) >= value)
            isCavity = false;

        if(Integer.parseInt(Character.toString(grid[i+1].charAt(j))) >=value)
            isCavity = false;

        if(Integer.parseInt(Character.toString(grid[i].charAt(j+1))) >=value)
            isCavity = false;

        if(Integer.parseInt(Character.toString(grid[i].charAt(j-1))) >=value)
            isCavity = false;
 
        if(isCavity)
            result[i].setCharAt(j,'X');
     }
    
    }
 
     for(int i=0; i<n;i++)
            System.out.println(result[i]);
 }


}
