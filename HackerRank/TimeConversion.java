import java.util.*;
import java.text.*;
import java.io.*;

public class TimeConversion
{

    public static void main(String [] args) throws Exception
    {
       Scanner scanner = new Scanner(System.in);
       String time = "12:45:54AM";
       String finalTime; 
       String time1  = time.substring(0,time.length()-2);
       String time2 = time.substring(time.length()-2, time.length());

       try
       {

           DateFormat df = new SimpleDateFormat("hh:mm:ssa");
           DateFormat out = new SimpleDateFormat("HH:mm:ss");
           Date date = df.parse(time);
           System.out.println(out.format(date));
       }
       catch (ParseException e)
       {
          e.printStackTrace();

       }
       if(time2.equals("PM"))
       {
         String time3[] = time1.split(":");
         int time4 = Integer.parseInt(time3[0]);
       
         if(time4 == 12)
         {
          finalTime = time4 +":"+ time3[1]+":" + time3[2];
         }
         else
         {
         
         time4 +=12;
       
         if(time4>=24)
         {
            
          finalTime = "00" +":"+ time3[1]+":" + time3[2];
         }
         
         finalTime = time4 +":"+ time3[1]+":" + time3[2];
        
         }
         
         System.out.println(finalTime);

       }
       else
       {

         String time3[] = time1.split(":");
         int time4 = Integer.parseInt(time3[0]);

         if(time4 == 12)
          finalTime = "00" +":"+ time3[1]+":" + time3[2];
         else
          finalTime = time1;
         
         System.out.println(finalTime);
       }
    }

}
