import java.util.*;

public class AcmIcpcTeam
{

  public static void main(String args[])
  {
     Scanner in = new Scanner(System.in);

     int n = in.nextInt();
     int m = in.nextInt();

     String topic[] = new String[n];

     for(int i=0; i<n; ++i)
       topic[i] = in.next();  

     
   HashMap<String,ArrayList<Integer>> data = new HashMap<String,ArrayList<Integer>>();


     /*
     HashMap<Integer,ArrayList<Integer>> data = new HashMap<Integer,ArrayList<Integer>>();

      for(int i=0; i<n; ++i)
      {
     
        ArrayList<Integer> temp = new ArrayList<Integer>();
         
        for(int j=0; j<m; ++j)
        {
            if(topic[i].charAt(j) == '1')
            {
                 temp.add(j); 
            }

        }

        data.put(i,temp);

      }

      for(Map.Entry<Integer, ArrayList<Integer>> entry : data.entrySet())
      {
          System.out.println(entry.getKey());

          for(int k:entry.getValue())
                System.out.print(k + " ");

      }

      */

         //   System.out.println();
  
   for(int i=0; i<n ; ++i)
     {


         for(int j=i; j<n; ++j)
         {
         ArrayList<Integer> temp = new ArrayList<Integer>();
            if(i==j)
            continue;
   
            for(int k = 0; k<m; ++k)
            {

                temp.add(Integer.parseInt(Character.toString(topic[i].charAt(k))) | Integer.parseInt(Character.toString(topic[j].charAt(k))));
             //   System.out.print(Integer.parseInt(Character.toString(topic[i].charAt(k))) | Integer.parseInt(Character.toString(topic[j].charAt(k))));
            
            }

         //   System.out.println();

             
                data.put(Integer.toString(i) + Integer.toString(j), temp);

         }

     }

     int max = 0;
      for(Map.Entry<String, ArrayList<Integer>> entry : data.entrySet())
      {
         // System.out.println(entry.getKey());


          int temp = 0;

          for(int k:entry.getValue())
             if(k == 1)
              ++temp;

          if(temp > max)
                max = temp;
         
         //System.out.println();
      
      }

     int total = 0;

     for(Map.Entry<String, ArrayList<Integer>> entry : data.entrySet())
      {

          int temp = 0;

          for(int k:entry.getValue())
             if(k == 1)
              ++temp;

          if(temp == max)
                ++total;
         
         //System.out.println();
      
      }
      System.out.println(max);
      System.out.println(total);
  }

}
