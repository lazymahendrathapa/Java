import java.util.*;

public class UtopianTree
{

    public static void main(String[] args)
    {

    Scanner in = new Scanner(System.in);
  
    int t = in.nextInt();


    for(int i=0; i<t; ++i)
    {

    int n = in.nextInt();

    int height = 1;

 

    for(int j = 1; j<=n; ++j)
    {
        if(j%2 == 0)
            height +=1;
        else
          height *=2;
    }

    System.out.println(height);
    
    }


    }

}
