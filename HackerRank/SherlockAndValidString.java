import java.util.*;

public class SherlockAndValidString 
{
  public static void main(String args[])
  {

   Scanner in = new Scanner(System.in);

   String input = in.next();
  
   HashMap<String, Integer> table = new HashMap<String, Integer>();

   for(int i=0; i<input.length(); ++i)
   {
           if(table.containsKey(Character.toString(input.charAt(i))))
            {
                int temp = table.get(Character.toString(input.charAt(i)));

                table.put(Character.toString(input.charAt(i)), ++temp);
            }
           
           else
            {
               table.put(Character.toString(input.charAt(i)), 1);

            }
      
   }

   Set<Map.Entry<String, Integer>> set = table.entrySet();
  
   int flag = table.get(Character.toString(input.charAt(0)));
  
   int count = 0;
   int value = 0;

   for(Map.Entry<String, Integer> me : set)
   {
     if(flag != me.getValue())
            ++count;

     if(count>1)
     {
        System.out.println("NO");
        break;
     }

     if(count == 1)
      value = me.getValue();

   }

    
    if(count == 0)
            System.out.println("YES");
    else if(count == 1)
    {
       if(Math.abs(flag - value) >1)
            System.out.println("NO");
       else
            System.out.println("YES");
    }

    if(input.length == 1)
        System.out.println("YES");

  }

}
