import java.util.*;

public class TwoString
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for(int i=0; i<t; ++i)
    {
      String first = in.next();
      String second = in.next();

      boolean flag = false;

      Set<String> set = new HashSet<String>();

      for(int j=0; j<first.length();++j)
            set.add(Character.toString(first.charAt(j)));

      
      for(String temp: set)
      {
          if(second.contains(temp))
            {
                flag = true;
                break;
            }

      }

      if(flag)
            System.out.println("YES");
      else
            System.out.println("NO");


    }

  }

}
