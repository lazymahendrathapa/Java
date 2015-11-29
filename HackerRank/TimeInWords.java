import java.util.*;

public class TimeInWords
{

 public static void main(String args[])
 {
  Scanner in = new Scanner(System.in);
  int h = in.nextInt();
  int m = in.nextInt();

   HashMap<Integer, String> table = new HashMap<Integer, String>();

   table.put(1,"one");
   table.put(2,"two");
   table.put(3,"three");
   table.put(4,"four");
   table.put(5,"five");
   table.put(6,"six");
   table.put(7,"seven");
   table.put(8,"eight");
   table.put(9,"nine");
   table.put(10,"ten");
   table.put(11,"eleven");
   table.put(12,"twelve");
   table.put(13,"thirteen");
   table.put(14,"fourteen");
   table.put(15,"fifteen"); 
   table.put(16,"sixteen"); 
   table.put(17,"seventeen"); 
   table.put(18,"eighteen"); 
   table.put(19,"ninteen");
   table.put(20,"twenty");

   for(int i= 1; i<10; ++i)
        table.put(20+i,table.get(20) +" "+ table.get(i));

   if(m == 0)
        System.out.println(table.get(h)+ " o' clock");
  
   else if(m>0 && m<9)
         System.out.println(table.get(m)+" minute past " + table.get(h)); 

   else if(m == 15)
          System.out.println("quarter past " + table.get(h)); 

   else if(m>10 && m<30)
         System.out.println(table.get(m)+" minutes past " + table.get(h)); 
 
   else if(m==30)
          System.out.println("half past " + table.get(h)); 

   else if(m>30 && m<45)
         System.out.println(table.get(m)+" minutes to " + table.get(h+1)); 

   else if(m==45)
          System.out.println("quarter to " + table.get(h+1)); 

   else if(m>45 && m <60)
         System.out.println(table.get(m)+" minutes past " + table.get(h+1)); 

  }
}
