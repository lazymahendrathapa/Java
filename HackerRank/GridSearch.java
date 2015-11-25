import java.util.*;

public class GridSearch
{
  public static void main(String args[])
  {
    
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();

      for(int i = 0; i<t; ++i)
      {
           int R = in.nextInt();
           int C = in.nextInt();

           String G[] = new String[R];
          
           for(int j=0; j<R; ++j)
                G[j] = in.next();

           int r = in.nextInt();
           int c = in.nextInt();

           String P[] = new String[r];

           for(int j = 0; j<r; ++j)
                P[j] = in.next();


           boolean flag = false;

           for(int j = 0; j <R; ++j)
           {
               if(G[j].contains(P[0]))
                {
                   flag = true;

                   int k = j + 1;

                    int value = G[j].indexOf(P[0]); 

                   for(int z =1; z<r; ++z)
                   {
                      if(G[k].contains(P[z]) && G[k].indexOf(P[z]) == value)
                            flag = true;
                      else
                            {
                            flag = false;
                             break;
                            }
                      ++k;
                        
                   }

                }

               if(flag == true)
                 {
                     break;
                 
                 }
           }

           if(flag == true)
                System.out.println("YES");
           else
                System.out.println("NO");



      }


  }

}
