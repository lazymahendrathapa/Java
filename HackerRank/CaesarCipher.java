import java.util.*;

public class CaesarCipher
{

 public static void main(String args[])
 {


    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    String text = in.next();

    char[] input = new char[text.length()];
   
    int k = in.nextInt();
    
    for(int i=0; i<text.length(); ++i)
        input[i] = text.charAt(i);


    for(int i=0; i<text.length(); ++i)
    {
     if(Character.isLetter(input[i]))
     {
         
            int value = (int)input[i] + k%26;
            

            if(Character.isLowerCase(input[i]))
                 {
                   
                    if(value >(int)'z')
                        value = value - 26;

                 }
             else if(Character.isUpperCase(input[i]))
             {
                   if(value > (int)'Z')
                        value =  value - 26;

             }


            input[i] = (char)value;

     }

    }

    for(int i=0; i<n; ++i)
        System.out.print(input[i]); 

    System.out.println();

 }

}

