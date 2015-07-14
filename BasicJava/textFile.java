import java.io.*;

public class textFile
{
        public static void main(String [] args)
        {
            String fileName = "temp.txt";

            try
            {
               FileWriter fileWriter = new FileWriter(fileName);

               BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter);

               bufferedWriter.write("Hello there ");
               bufferedWriter.write("here is some one");
               bufferedWriter.newLine();
               bufferedWriter.write("We are writing");

               bufferedWriter.close();
            }

            catch(IOException ex)
            {

               System.out.println("Error writing to file " + fileName );
        
            }

            try 
            {

                String line;
                FileReader fileReader = new FileReader(fileName);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null)
                    System.out.println(line);

                bufferedReader.close();

            }
            catch(FileNotFoundException ex)
            {
                System.out.println("Unable to open file " + fileName);
            }
            catch(IOException ex)
            {
              
               System.out.println("Error reading to file " + fileName );
            }

        }
}
