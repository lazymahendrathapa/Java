import java.util.*;
public class LoveLetterMystery
{
  public static void main(String args[])
  {
   Scanner in = new Scanner(System.in);

   int t = in.nextInt();

   for(int i=0; i<t; ++i){
      
        StringBuilder input = new StringBuilder(in.next());
        StringBuilder temp = input;

        if(input.toString().equals(temp.reverse().toString()))
                System.out.println("0");
        else{
   
                int length = input.length();
                
                int count = 0;

                for(int j=0; j<length/2; ++j){

                  if(input.charAt(j)<input.charAt(length-j-1)){
                   
                        int a = (int)input.charAt(length-j-1);
               
                    while(true){
                        --a;
                        ++count;

                        if((int)input.charAt(j) == a)
                                break;
                    }

                        input.setCharAt(length-j-1,(char)a); 
                  
                  }else if(input.charAt(j)>input.charAt(length-j-1)){
                  
                        int a = (int)input.charAt(j);
               
                    while(true){
                        --a;
                        ++count;

                        if((int)input.charAt(length-j-1) == a)
                                break;
                    }

                        input.setCharAt(j,(char)a); 
                  
                  }

                }

                System.out.println(count);
        
        }

   }



  }
}
