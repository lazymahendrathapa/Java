import java.util.*;

public class Pangrams
{
  public static void main(String args[])
  {

    Scanner in = new Scanner(System.in);

    String string = in.nextLine();

   Set<String> set = new HashSet<String>();
   Set<String> res = new HashSet<String>();

   for(int i=0; i<string.length(); ++i)
        set.add(Character.toString(string.charAt(i)).toLowerCase());
 
    for(String temp : set)
    {
      if((temp.compareTo("a")>=0 && temp.compareTo("z")<=0)) 
      {
             res.add(temp);       
        System.out.print(temp); 
      }
    }
 
        System.out.println();
    if(res.size()==26)
        System.out.println("pangram");
    else
        System.out.println("not pangram");

  }

}
