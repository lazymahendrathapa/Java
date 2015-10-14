import java.io.*;

public class synonyms
{

  public static void main(String [] args)
  {

//reading file
   try
   {
 
        String fileName = "output.txt";
        String fileresult = "synonyms.txt";

        String line;

        FileReader fileReader = new FileReader(fileName);
        FileWriter fileWriter = new FileWriter(fileresult); 

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while((line = bufferedReader.readLine()) != null)
        {


            while(line.equals("Synonyms:"))
             {

                String temp = " ";
                char t; 
                while( (t =(char)bufferedReader.read()) != '.')
                     temp += t;

                bufferedWriter.write(temp); 
                bufferedWriter.write('\n');

                break;
                   
             }

          
           while(line.equals("*****"))
            {
             
             line = bufferedReader.readLine();
             line = bufferedReader.readLine();
            
             int place = line.length();

             boolean flag = true;

             for(int i=0; i<(place-1); ++i)
             {
                if(line.charAt(i) >='A' && line.charAt(i) <='Z')
                   continue;
                else
                {
                  flag = false;
                  break;
                }
             }

             if(flag)
             {
                bufferedWriter.write('\n');
                bufferedWriter.write(line); 
                bufferedWriter.write('\n');
             }

             break;
            }
        }

         bufferedReader = new BufferedReader(fileReader);

         while((line = bufferedReader.readLine()) != null)
         {
            String temp = line.replace(',',' ');

             bufferedWriter.write(line); 

         }

        bufferedReader.close();
        bufferedWriter.close();

   }catch(FileNotFoundException ex)
   {
        System.out.println("Unable to open file");
   }
   catch(IOException ex)
   {
     System.out.println("Error reading to file"); 
   }

  }
}
