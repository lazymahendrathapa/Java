import java.util.*;

public class Encryption
{
  public static void main(String args[])
  {
     Scanner in = new Scanner(System.in);
     String s = in.nextLine();

     StringBuilder string = new StringBuilder();

      for(int i =0; i<s.length(); ++i)
            if(s.charAt(i) != ' ')
               string.append(Character.toString(s.charAt(i)));  

     int l = string.length();

     int rows = (int)Math.sqrt(l); 
     int cols; 

     if(rows * rows >=l)
            cols = rows;
     else
            cols = rows+1;

     if(rows*cols<l)
             ++rows;


     String res[] = new String[rows];
   
     int j = 0;

     if(rows*cols<l)
             ++rows;

     for(int i=0; i<rows; ++i)
     {
           
            if(j+cols<l)
           { 
             res[i] = string.substring(j, j+cols);
             j+=cols; 
           }
           else
           {
             res[i] = string.substring(j,l);
             break;
           }

     }

     for(int i=0; i<cols; ++i)
     { 
       for(int k=0; k<rows; ++k)
        {
          if(res[k].length()>i)
           System.out.print(res[k].charAt(i));
         
          else
            break; 

        }

       System.out.print(" ");

     }
           
  }

}
