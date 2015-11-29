import java.util.*;

public class AcmIcpcTeam2
{

          public static void main(String args[])
                {
                Scanner in = new Scanner(System.in);
                 int n = in.nextInt();
                 int m = in.nextInt();
                  String topic[] = new String[n];

                  for(int i=0; i<n; ++i)
                          topic[i] = in.next();  
                           

                int max = 0;
                int total = 0;

                  for(int i=0; i<n ; ++i)
                    {
                      for(int j=i + 1; j<n; ++j)
                        {

                          int val = 0;

                        for(int k = 0; k<m; ++k)
                         {
                          if(topic[i].charAt(k) == '1' || topic[j].charAt(k)== '1')
                            ++val; 
                        }

                        if(max<val)
                        {
                          max = val;
                          total = 1;
                        }
                        else if(max == val)
                            ++total;
                      }
                    
                    }
                                                                                         
               System.out.println(max);
               System.out.println(total);
    }

}

