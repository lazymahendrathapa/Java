import java.util.*;

public class InsertionSort
{

    private int[] array;
    private int length;

        public static void main(String args[])
        {

           InsertionSort is = new InsertionSort();
           is.takeInput();
          
           is.ascendingSorting();
           System.out.println("Ascending Order: ");
           is.printResult();
         
           is.descendingSorting();
           System.out.println("Descending Order: ");
           is.printResult();
        }

       void takeInput()
       {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the length of array: ");
         length = scanner.nextInt();

         array = new int[length];

         System.out.println("Enter the array: ");
         for(int i=0; i<length; ++i)
         {
              array[i] = scanner.nextInt();

         }


       }

       void ascendingSorting()
       {
         for(int j=1; j<array.length; ++j)
         {
              int key = array[j];
              int i = j - 1;
              while(i>=0 && array[i]>key)
                   {
                       array[i+1] = array[i];
                       --i;
                   }
            array[i+1] = key;
         }
       }

       void descendingSorting()
       {

               for(int j=1; j<array.length; ++j)
               {
                int key = array[j];
                int i = j-1;
                while(i>=0 && array[i]<key)
                {
                     array[i+1] = array[i];
                     --i;
                }
                array[i+1] = key;
               }
       }

       void printResult()
       {
            for(int i:array)
            System.out.println(i + " ");
       }

}
